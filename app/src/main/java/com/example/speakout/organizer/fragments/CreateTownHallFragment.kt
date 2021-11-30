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
import com.example.speakout.databinding.FragmentCreateTownHallBinding
import com.google.android.gms.common.FirstPartyScopes
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class CreateTownHallFragment : DialogFragment()
{
    var date:TextInputEditText?=null;
    var start:TextInputEditText?=null;
    var end:TextInputEditText?=null;
    var details:TextInputEditText?=null;

    var town_hall_close_btn_id:Button?= null
    var town_hall_create_btn_id:Button?= null
    val database=Firebase.database
    val reference=database.getReference("speak_out")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_create_town_hall, container, false)
        setInputFields(rootView)
        creat_Town_Hall(rootView)
        closeDialog(rootView)

        return rootView
    }

    private fun setInputFields(rootView: View?)
    {
        date=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_date_id)
        start=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_start_date_id)
        end=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_end_date_id)
        details=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_details_id)
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
                Toast.makeText(context, date!!.text.toString()+" "+reference.child("user").toString(), Toast.LENGTH_LONG).show()
            }
        }

}