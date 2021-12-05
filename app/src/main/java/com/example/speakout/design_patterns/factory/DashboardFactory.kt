package com.example.speakout.design_patterns.factory

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.speakout.design_patterns.strategy.DecideDashboard
import com.example.speakout.design_patterns.strategy.GoToOrganizer
import com.example.speakout.design_patterns.strategy.GoToStudent
import com.google.firebase.database.ValueEventListener

/**
 * DashboardFactory.kt is a factory that will generate a dashboard to a user basing on their roles
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
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
                dashboard=GoToOrganizer(context)
            }
            return dashboard
        }
    }
}