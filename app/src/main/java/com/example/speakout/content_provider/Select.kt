package com.example.speakout.content_provider

import com.example.speakout.design_patterns.composite.CommentPattern
import com.example.speakout.general.classess.User

interface Select
{
    fun selectTownHalls()
    fun selectQuestion(townhall:String,parent:Int):String
    fun selectComments(question:Int)
    fun selectUser(andrew:String,password:String):User?
}