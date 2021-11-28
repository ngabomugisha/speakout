package com.example.speakout.student.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.speakout.R
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.databinding.ActivityViewQuestionsStudentBinding
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.fragments.ViewQuestionsFragment

class ViewQuestionsStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewQuestionsStudentBinding
    private lateinit var post_btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityViewQuestionsStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        post_btn=binding.postQuestionBtnId
        startFragments()

        postClicked()

    }

    private fun postClicked()
    {
        post_btn.setOnClickListener {
            Toast.makeText(this, "Yes go", Toast.LENGTH_LONG).show()
        }
    }

    private fun startFragments()
    {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(com.example.speakout.R.id.view_towhalls_questions_student_fragment_id, ViewQuestionsFragment::class.java,null)
        transaction.commit()
    }
}