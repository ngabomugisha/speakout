package com.example.speakout.organizer.activities

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.classes.TownHallViewClass
import com.example.speakout.organizer.fragments.CreateTownHallFragment
import com.example.speakout.organizer.fragments.ViewQuestionsFragment
import com.example.speakout.organizer.recycler_views.RecyclerViewTownHallAdapter
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

/**
 * OrganizerDashboardActivity.kt is a class for town hall organizer dashboard.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class OrganizerDashboardActivity : AppCompatActivity() {
    private var beginTownHall:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer_dashboard)

        beginTownHall=findViewById<Button>(R.id.start_townhall_btn_id)

        clickable()
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

    private fun clickable() {
        beginTownHall?.setOnClickListener {

            var dialog = CreateTownHallFragment()
            dialog.show(supportFragmentManager, "DialogFragment")
        }
    }

}