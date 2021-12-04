package com.example.speakout.design_patterns.strategy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.speakout.organizer.activities.OrganizerDashboardActivity

class GoToStudent(private var c: AppCompatActivity) : DecideDashboard
{
    override fun goToDashboard(): Intent
    {
        return Intent(c, OrganizerDashboardActivity::class.java)
    }
}