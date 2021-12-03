package com.example.speakout.organizer.fragments

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import android.widget.DatePicker

import android.app.Dialog
import com.example.speakout.general.Townhall
import com.example.speakout.organizer.classes.SelectDateFragment
import com.example.speakout.utils.Helper
import com.example.speakout.MainActivity

import androidx.annotation.NonNull
import com.google.firebase.database.*
import java.sql.Time


class CreateTownHallFragment : DialogFragment()
{
    private var date:TextView?=null;
    private var start:TextView?=null;
    private var end:TextView?=null;
    private var details:TextInputEditText?=null;

    private var town_hall_close_btn_id:Button?= null
    private var town_hall_create_btn_id:Button?= null
    private var database: DatabaseReference? = null

    private var newFragment: DialogFragment?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = FirebaseDatabase.getInstance().getReference("speak_out")
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_create_town_hall, container, false)
        setInputFields(rootView)
        creat_Town_Hall(rootView)
        closeDialog(rootView)

        // handling select dates
        dateClicked()
        selectStartDate()
        selectEndDate()

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
    private fun creat_Town_Hall(rootView: View) {
        town_hall_create_btn_id = rootView.findViewById(R.id.town_hall_start_btn_id)
        town_hall_create_btn_id?.setOnClickListener {
            if (!fieldsValidate())
            {

            }
            else
            {
                var d:String=date!!.text.toString()
                val s:String=Helper.changeDate(start!!.text.toString())
                val e:String=Helper.changeDate(end!!.text.toString())
                val det:String=details!!.text.toString()
                var id=Helper.changeDate(d)
                d=Helper.changeDate(d)

                val townhall:Townhall= Townhall(id,s,e,d,1,"001",det)
                database?.child("townhall/${townhall.getTownhallId()}")?.setValue(townhall)
                Toast.makeText(context,"Townhall saved successfully",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun fieldsValidate(): Boolean
    {
        val d:String=date!!.text.toString()
        val s:String=start!!.text.toString()
        val e:String=end!!.text.toString()
        val det:String=details!!.text.toString()

        if(d.trim().isEmpty() || s.trim().isEmpty() || e.trim().isEmpty())
        {
            Toast.makeText(context, "Please, all fields are required", Toast.LENGTH_LONG)
            .show()
            return false
        }
        else if(2==3) // replace this to date start date, and end date validation
        {
            return false
        }
        return true;
    }

    private fun clickDatePicker(view:View, a:String)
    {
        newFragment = SelectDateFragment()
        (newFragment as SelectDateFragment).show(requireFragmentManager(), "DatePicker")
        (view as TextView).text = (newFragment as SelectDateFragment).getDate()
        (newFragment as SelectDateFragment).setRootView(view)
        (newFragment as SelectDateFragment).setTextView(a)
    }

    // When Town_hall date is clicked, the following codes allows to select the date
    private fun dateClicked()
    {
        date!!.setOnClickListener { view->
            clickDatePicker(view,"date")
        }
    }

    // When start date is clicked, the following codes allows to select the date
    private fun selectStartDate()
    {
        start!!.setOnClickListener { view->
            clickDatePicker(view, "start")
        }
    }

    // When end date is clicked, the following codes allows to select the date
    private fun selectEndDate()
    {
        end!!.setOnClickListener { view->
            clickDatePicker(view, "end")
        }
    }
}
