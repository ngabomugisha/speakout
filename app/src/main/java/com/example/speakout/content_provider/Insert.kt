package com.example.speakout.content_provider

import com.example.speakout.general.classess.Question
import com.example.speakout.general.classess.Townhall
/**
 * Insert.kt is an interface to insert data into database.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
interface Insert
{
    fun insertTownHall(townhall:Townhall)
    fun insertQuestion(question:Question)
    fun voteQuestion(voter:String, question:String,vote:Int)
}