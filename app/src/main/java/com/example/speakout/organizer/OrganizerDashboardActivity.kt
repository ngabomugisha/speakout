package com.example.speakout.organizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R

class OrganizerDashboardActivity : AppCompatActivity() {
    private var recycler:RecyclerView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer_dashboard)
        recycler=findViewById<RecyclerView>(R.id.recycler_view_holder_id)

        val halls:ArrayList<TownHallViewClass> = ArrayList();
        for (i in 1..20)
        {
            halls.add(TownHallViewClass("Spring 202$i","202-12-01"))
        }

        val adapter= RecyclerViewTownHallAdapter(halls);
        recycler?.adapter=adapter
    }
}