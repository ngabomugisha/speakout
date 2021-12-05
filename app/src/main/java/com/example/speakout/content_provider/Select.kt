package com.example.speakout.content_provider

import com.example.speakout.design_patterns.composite.CommentPattern
import com.example.speakout.general.classess.User

/**
 * Select.kt is an interface to select data from database.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
interface Select
{
    fun selectTownHalls()
    fun selectQuestion(townhall:String,parent:Int):String
    fun selectComments(question:Int)
    fun selectUser(andrew:String,password:String):User?
}