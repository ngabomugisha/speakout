package com.example.speakout.content_provider

import com.example.speakout.general.classess.Question
import com.example.speakout.general.classess.Townhall

interface Insert
{
    fun insertTownHall(townhall:Townhall)
    fun insertQuestion(question:Question)
    fun voteQuestion(voter:String, question:Int,vote:Int)
}