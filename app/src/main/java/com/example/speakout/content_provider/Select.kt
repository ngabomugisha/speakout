package com.example.speakout.content_provider

import com.example.speakout.general.classess.User

interface Select
{
    fun selectTownHalls()
    fun selectQuestion(townhall:String)
    fun selectComments(question:Int)
    fun selectUser(andrew:String,password:String):User?
}