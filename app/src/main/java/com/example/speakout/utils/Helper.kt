package com.example.speakout.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Helper.kt is a Helper class that contains some utility functions
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
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