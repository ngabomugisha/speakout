package com.example.speakout.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class Helper
{
    companion object
    {
        fun validateStartEndDate(s:String, e:String):String
        {
            return "Amen"
        }

        fun todayDate(): String {
            val calendar: Calendar = Calendar.getInstance()
            val dateFormat: DateFormat = SimpleDateFormat("MM/dd/yyyy")
            return dateFormat.format(calendar.time)
        }

        fun changeDate(date:String)=date.replace('/','-')
    }
}