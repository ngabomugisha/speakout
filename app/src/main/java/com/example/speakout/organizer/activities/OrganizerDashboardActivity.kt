package com.example.speakout.organizer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            Toast.makeText(this, "Here we gon start a new Town Hall", Toast.LENGTH_LONG).show()
            var dialog = CreateTownHallFragment()
            dialog.show(supportFragmentManager, "DialogFragment")
        }
    }
}