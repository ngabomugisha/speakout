package com.example.speakout.organizer.classes

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R
import java.util.*

// inner class to help us display DatePickerFragment
 class SelectDateFragment() : DialogFragment(),
    DatePickerDialog.OnDateSetListener
{
    private var v:TextView?=null
    private var root:View?=null
    private var selectedDate:String?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        val calendar = Calendar.getInstance()
        val yy = calendar[Calendar.YEAR]
        val mm = calendar[Calendar.MONTH]
        val dd = calendar[Calendar.DAY_OF_MONTH]
        val dateDialog =
            DatePickerDialog(requireActivity(), this, yy, mm, dd)
        dateDialog.datePicker.minDate=System.currentTimeMillis()
        return dateDialog
    }

    override fun onDateSet(view: DatePicker, yy: Int, mm: Int, dd: Int)
    {
        populateSetDate(yy,mm,dd)
    }

    fun getDate()=selectedDate

    fun setRootView(r:View)
    {
        root=r
    }
    fun setTextView(s:String)
    {
        if(s.contentEquals("date"))
        {
            v=root!!.findViewById(R.id.town_hall_date_id)
        }
        else if(s.contentEquals("start"))
        {
            v=root!!.findViewById(R.id.town_hall_start_date_id)
        }
        else if(s.contentEquals("end"))
        {
            v=root!!.findViewById(R.id.town_hall_end_date_id)
        }
    }

    private fun populateSetDate(year: Int, month: Int, day: Int)
    {
        v!!.text = "$month/$day/$year"
    }
}