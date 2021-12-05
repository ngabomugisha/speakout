package com.example.speakout.student.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.speakout.R
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.databinding.ActivityViewQuestionsStudentBinding
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.fragments.CreateTownHallFragment
import com.example.speakout.organizer.fragments.ViewQuestionsFragment
import com.example.speakout.student.fragments.PostQuestionFragment

class ViewQuestionsStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewQuestionsStudentBinding
    private lateinit var post_btn:Button
    private var townhall_id:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewQuestionsStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        post_btn=binding.postQuestionBtnId

        townhall_id= intent.getStringExtra("townhall_id").toString()
        startFragments()

        postClicked()

    }

    private fun postClicked()
    {
        post_btn.setOnClickListener {
            var dialog = PostQuestionFragment()
            dialog.show(supportFragmentManager, "DialogFragment")
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
}