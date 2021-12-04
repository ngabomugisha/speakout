package com.example.speakout.general.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.speakout.R
import com.example.speakout.databinding.ActivityLoginBinding
import com.example.speakout.databinding.ActivitySignUpBinding
import com.example.speakout.organizer.activities.OrganizerDashboardActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var andrew_id_login_id: EditText
    private lateinit var binding: ActivityLoginBinding
    private lateinit var bindingSignUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindingSignUpBinding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(bindingSignUpBinding.root)

        andrew_id_login_id=findViewById(R.id.andrew_id_login_id)

        val login=binding.loginBtnId
        login.setOnClickListener {
            loginBtnClicked()
            saveSession()//save andrew id on the first login
        }

        val signup=bindingSignUpBinding.signupSignupBtnId
        signup.setOnClickListener {
//            loginBtnClicked()
//            saveSession()//save andrew id on the first login
            Toast.makeText(this,"Let's log in...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loginBtnClicked()
    {
        val intent: Intent = Intent(this, OrganizerDashboardActivity::class.java)
        startActivity(intent)
    }

    private fun saveSession() {
        val insertedAndrewId:String = andrew_id_login_id.text.toString()//save login
        val sharedPreferences: SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedAndrewId)
        }.apply()
        Toast.makeText(this,insertedAndrewId+"Login Saved for ever", Toast.LENGTH_SHORT).show()
    }
}