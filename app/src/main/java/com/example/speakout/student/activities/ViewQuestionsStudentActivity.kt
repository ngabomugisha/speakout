package com.example.speakout.student.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View

import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.speakout.R
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.databinding.ActivityViewQuestionsStudentBinding
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.fragments.CreateTownHallFragment
import com.example.speakout.organizer.fragments.Fragment_comment
import com.example.speakout.organizer.fragments.ViewQuestionsFragment
import com.example.speakout.student.fragments.PostQuestionFragment

/**
 * ViewQuestionsStudentActivity.kt is an activity to view student questions
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class ViewQuestionsStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewQuestionsStudentBinding
    private lateinit var post_btn:Button
    private var townhall_id:String=""
    private var post_layout:LinearLayout?=null
    private var view_questions:LinearLayout?=null
    private var fragment_layout:LinearLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewQuestionsStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        post_btn=binding.postQuestionBtnId
        post_layout=binding.aboveLayoutId1
        view_questions=binding.aboveLayoutId
        fragment_layout=binding.fragmentLayoutId

        townhall_id= intent.getStringExtra("townhall_id").toString()

        differentiateUsers()
        startFragments()
        postClicked()

    }

    private fun hide(v: View?)
    {
        v?.isVisible=false
    }

    private fun show(v: View?)
    {
        v?.isVisible=true
    }

    private fun postClicked()
    {
        post_btn.setOnClickListener {
            var fragment = PostQuestionFragment()
            var bundle:Bundle= Bundle()
            bundle.putString("townhall_id",townhall_id)
            fragment.arguments=bundle
            fragment.show(supportFragmentManager, "DialogFragment")
        }
    }

    private fun startFragments()
    {
        var bundle:Bundle= Bundle()
        bundle.putString("townhall_id",townhall_id)
        val fragment:Fragment=ViewQuestionsFragment()
        fragment.arguments=bundle
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(com.example.speakout.R.id.view_towhalls_questions_student_fragment_id, fragment,null)
        transaction.commit()
    }


    private fun differentiateUsers() {
        val sp: SharedPreferences? =this?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedAndrewId:String?=sp?.getString("ANDREW_ID", null)
        val savedRole:String?=sp?.getString("ROLE", null)

        if(savedRole=="organizer")
        {
            show(view_questions)
            hide(post_layout)
//            hide(fragment_layout)
        }
        if(savedRole=="student")
        {
            show(post_layout)
            show(fragment_layout)
            hide(view_questions)
        }
    }

}