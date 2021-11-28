package com.example.speakout.organizer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.TownHallViewClass
import com.example.speakout.organizer.recycler_views.RecyclerViewTownHallAdapter

class OrganizerDashboardActivity : AppCompatActivity() {
    private var recycler:RecyclerView?=null;
    private var beginTownHall:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer_dashboard)
        recycler=findViewById<RecyclerView>(R.id.recycler_view_holder_id)
        beginTownHall=findViewById<Button>(R.id.start_townhall_btn_id)

        val halls:ArrayList<TownHallViewClass> = ArrayList();
        for (i in 1..30)
        {
            halls.add(TownHallViewClass("Spring 202$i","202-12-01"))
        }

        val adapter= RecyclerViewTownHallAdapter(halls);
        recycler?.adapter=adapter

        clickable()
    }

    private fun clickable() {
        beginTownHall?.setOnClickListener {
            Toast.makeText(this, "Here we gon start a new Town Hall", Toast.LENGTH_LONG).show()
        }
    }
}