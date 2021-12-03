package com.example.speakout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.general.activities.LoginActivity
import com.example.speakout.general.fragments.OrganizerOneTownHallActivity
import com.example.speakout.student.activities.ViewQuestionsStudentActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val question=binding.question
        question.setOnClickListener {
            questionClicked()
        }

        val post=binding.post
        post.setOnClickListener {
            postClicked()
        }

        val login=binding.login
        login.setOnClickListener {
            loginClicked()
        }
    }

    private fun loginClicked()
    {
        val intent:Intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun postClicked()
    {
        val intent:Intent= Intent(this,ViewQuestionsStudentActivity::class.java)
        startActivity(intent)
    }

    private fun questionClicked()
    {
        val intent:Intent=Intent(this, OrganizerOneTownHallActivity::class.java)
        startActivity(intent)
    }

}