package com.example.speakout.general.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.speakout.R
import com.example.speakout.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var andrew_id_signup: EditText
    private lateinit var password_signup: EditText
    private lateinit var full_name_signup: EditText
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        andrew_id_signup=findViewById(R.id.andrew_id_signup)
        password_signup=findViewById(R.id.password_signup)
        full_name_signup=findViewById(R.id.full_name_signup)

        val signup=binding.signupSignupBtnId
        signup.setOnClickListener {
            signupBtnClicked()
        }
    }

    private fun signupBtnClicked()
    {
        val intent: Intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}