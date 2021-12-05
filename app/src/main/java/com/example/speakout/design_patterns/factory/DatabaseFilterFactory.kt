package com.example.speakout.design_patterns.factory

import com.example.speakout.design_patterns.filter.DatabaseFilter
import com.example.speakout.design_patterns.filter.QuestionFilter
import com.example.speakout.design_patterns.filter.TownhallFilter
import com.example.speakout.design_patterns.filter.UserFilter

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