package com.example.speakout.content_provider

interface Select
{
    fun selectTownHalls()
    fun selectQuestion()
    fun selectComments(question:Int)
    fun selectUser(andrew:String,password:String)
}