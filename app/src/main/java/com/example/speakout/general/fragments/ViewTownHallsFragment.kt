package com.example.speakout.general.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.MainActivity
import com.example.speakout.R
import com.example.speakout.general.Townhall
import com.example.speakout.organizer.classes.TownHallViewClass
import com.example.speakout.organizer.recycler_views.RecyclerViewTownHallAdapter
import com.example.speakout.utils.DatabaseConnection
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

// TODO: Rename parameter arguments, choose names that match

class ViewTownHallsFragment : Fragment() {

    private var recycler:RecyclerView?=null;
    private var database:DatabaseReference?=null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database=DatabaseConnection.connect()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_town_halls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler=activity?.findViewById<RecyclerView>(R.id.recycler_view_holder_id)
        getTownhalls()
    }
    private fun getTownhalls()
    {
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var townhalls=snapshot.child("townhall").children
                var l:ArrayList<String> = ArrayList()
                var i:Int=0
                townhalls.forEach { _ ->
                    if(i!=0)
                    {
                        val t:Townhall=
                    }
                    i++
                }
                Toast.makeText(context,"$i",Toast.LENGTH_LONG).show()
            }
            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(context, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
//        val halls:ArrayList<TownHallViewClass> = ArrayList();
//        for (i in 1..30)
//        {
//            halls.add(TownHallViewClass("Spring 202$i","202-12-01"))
//        }
//
//        val adapter= RecyclerViewTownHallAdapter(halls);
//        recycler?.adapter=adapter
    }
}