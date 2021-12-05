package com.example.speakout.design_patterns.factory

import com.example.speakout.design_patterns.filter.DatabaseFilter
import com.example.speakout.design_patterns.filter.QuestionFilter
import com.example.speakout.design_patterns.filter.TownhallFilter
import com.example.speakout.design_patterns.filter.UserFilter

/**
 * DatabaseFilterFactory.kt is a class that will help to filter.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class DatabaseFilterFactory
{
    companion object
    {
        fun getValue(table:String): DatabaseFilter?
        {
            if(table=="user")
            {
                return UserFilter()
            }
            else if(table=="question")
            {
                return QuestionFilter()
            }
            else if (table=="townhall")
            {
                return TownhallFilter()
            }
            else
            {
                return null
            }
        }
    }
}