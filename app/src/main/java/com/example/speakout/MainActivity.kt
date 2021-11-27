package com.example.speakout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.organizer.activities.OrganizerDashboardActivity
import com.example.speakout.organizer.activities.OrganizerOneTownHallActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val to=binding.to
        to.setOnClickListener {
            toClicked()
        }

        val question=binding.question
        question.setOnClickListener {
            questionClicked()
        }
    }

    private fun questionClicked()
    {
        val intent:Intent=Intent(this, OrganizerOneTownHallActivity::class.java)
        startActivity(intent)
    }

    private fun toClicked() {
        val intent:Intent= Intent(this, OrganizerDashboardActivity::class.java)
        startActivity(intent)
    }
}