package com.example.speakout.organizer

class QuestionClass(private var question:String, private var poster:String, private var date:String, private var num_comments:String)
{
    fun getPoster()=poster;
    fun getDate()=date;
    fun getNumberOfComments()=num_comments;
    fun getQuestion()=question;
}