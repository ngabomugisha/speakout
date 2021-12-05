package com.example.speakout.student.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.speakout.R
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.fragments.CreateTownHallFragment

class StudentDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)

        startFragment()
    }

    private fun startFragment()
    {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(com.example.speakout.R.id.view_towhalls_fragment_id, ViewTownHallsFragment::class.java,null)
        transaction.commit()
    }

}