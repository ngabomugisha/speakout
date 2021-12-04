package com.example.speakout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

//        Getting saved Id during first login
        val sp: SharedPreferences =getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedAndrewId:String?=sp.getString("STRING_KEY", null)
        Toast.makeText(this,"AndrewId: "+savedAndrewId, Toast.LENGTH_SHORT).show()

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