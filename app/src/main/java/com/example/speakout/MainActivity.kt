package com.example.speakout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.organizer.OrganizerDashboardActivity
import com.example.speakout.organizer.TownHallViewClass

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
    }

    private fun toClicked() {
        val intent:Intent= Intent(this, OrganizerDashboardActivity::class.java)
        startActivity(intent)
    }
}