package com.example.speakout.organizer.classes

class QuestionClass(private var questionId:String, private var question:String, private var poster:String,
                    private var date:String, private var num_comments:String,private var votes:String)
{
    fun getId()=questionId;
    fun getPoster()=poster;
    fun getDate()=date;
    fun getNumberOfComments()=num_comments;
    fun getQuestion()=question;
    fun getVotes()=votes
}