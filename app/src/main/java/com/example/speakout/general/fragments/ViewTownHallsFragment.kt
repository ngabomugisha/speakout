package com.example.speakout.general.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.MainActivity
import com.example.speakout.R
import com.example.speakout.organizer.classes.TownHallViewClass
import com.example.speakout.organizer.recycler_views.RecyclerViewTownHallAdapter

// TODO: Rename parameter arguments, choose names that match

class ViewTownHallsFragment : Fragment() {

    private var recycler:RecyclerView?=null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_town_halls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler=activity?.findViewById<RecyclerView>(R.id.recycler_view_holder_id)
        val halls:ArrayList<TownHallViewClass> = ArrayList();
        for (i in 1..30)
        {
            halls.add(TownHallViewClass("Spring 202$i","202-12-01"))
        }

        val adapter= RecyclerViewTownHallAdapter(halls);
        recycler?.adapter=adapter

    }
}