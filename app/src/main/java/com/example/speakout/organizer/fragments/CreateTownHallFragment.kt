package com.example.speakout.organizer.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R
import com.google.android.gms.common.FirstPartyScopes


class CreateTownHallFragment : DialogFragment() {
    var town_hall_close_btn_id:Button?= null
    var town_hall_create_btn_id:Button?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_create_town_hall, container, false)

        creat_Town_Hall(rootView)
        closeDialog(rootView)



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    fun closeDialog (rootView: View) {

        town_hall_close_btn_id = rootView.findViewById(R.id.town_hall_close_btn_id)
        town_hall_close_btn_id?.setOnClickListener {
            dismiss()
        }
    }
        fun creat_Town_Hall(rootView: View) {
            town_hall_create_btn_id = rootView.findViewById(R.id.town_hall_start_btn_id)
            town_hall_create_btn_id?.setOnClickListener {
                Toast.makeText(context, "Create town hall ", Toast.LENGTH_LONG).show()
            }
        }

}