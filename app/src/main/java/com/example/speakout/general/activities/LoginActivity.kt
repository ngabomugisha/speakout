package com.example.speakout.general.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speakout.R
import com.example.speakout.databinding.ActivityLoginBinding
import com.example.speakout.organizer.activities.OrganizerDashboardActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login=binding.loginBtnId
        login.setOnClickListener {
            loginBtnClicked()
        }
    }

    private fun loginBtnClicked()
    {
        val intent: Intent = Intent(this, OrganizerDashboardActivity::class.java)
        startActivity(intent)
    }
}