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


class CreateTownHallFragment : DialogFragment()
{
    private var date:TextView?=null;
    private var start:TextView?=null;
    private var end:TextView?=null;
    private var details:TextInputEditText?=null;
    private var dateChoice:String?=null

    private var town_hall_close_btn_id:Button?= null
    private var town_hall_create_btn_id:Button?= null
    private val database=Firebase.database
    private val reference=database.getReference("speak_out")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_create_town_hall, container, false)
        setInputFields(rootView)
        creat_Town_Hall(rootView)
        closeDialog(rootView)

        // handling select dates on view clicks
        date!!.setOnClickListener { view->
            dateChoice="date"
            clickDatePicker(view)
        }

        start!!.setOnClickListener { view->
            dateChoice="start"
            clickDatePicker(view)
        }

        end!!.setOnClickListener { view->
            dateChoice="end"
            clickDatePicker(view)
        }
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
                if(!fieldsValidate())
                {

                }
                Toast.makeText(context, date!!.text.toString()+" "+reference.child("user").toString(), Toast.LENGTH_LONG).show()
            }
        }

    private fun fieldsValidate(): Boolean
    {
        return true;
    }

    private fun clickDatePicker(view:View)
    {
        val newFragment: DialogFragment = SelectDateFragment()
        newFragment.show(requireFragmentManager(), "DatePicker")
    }

    // inner class to help us display DatePickerFragment
    inner class SelectDateFragment : DialogFragment(),
        OnDateSetListener {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar = Calendar.getInstance()
            val yy = calendar[Calendar.YEAR]
            val mm = calendar[Calendar.MONTH]
            val dd = calendar[Calendar.DAY_OF_MONTH]
            return DatePickerDialog(requireActivity(), this, yy, mm, dd)
        }

        override fun onDateSet(view: DatePicker, yy: Int, mm: Int, dd: Int) {
            populateSetDate(yy, mm + 1, dd)
        }

        private fun populateSetDate(year: Int, month: Int, day: Int)
        {
            decideView()!!.text="$month/$day/$year"
        }
        private fun decideView(): TextView?
        {
            if(dateChoice.equals("date"))
            {
                return date
            }
            else if(dateChoice.equals("start"))
            {
                return start
            }
            else if(dateChoice.equals("end"))
            {
                return  end
            }
            else
            {
                return date
            }
        }
    }

}
