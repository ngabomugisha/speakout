package com.example.speakout.design_patterns.factory

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.speakout.design_patterns.strategy.DecideDashboard
import com.example.speakout.design_patterns.strategy.GoToStudent
import com.google.firebase.database.ValueEventListener

class DashboardFactory
{
    companion object
    {
        var dashboard:DecideDashboard?=null
        fun decideDashboard(context: AppCompatActivity, role:String):DecideDashboard?
        {
            if(role=="student")
            {
                dashboard= GoToStudent(context)
            }
            if(role=="organizer")
            {
                dashboard=GoToStudent(context)
            }
            return dashboard
        }
    }
}