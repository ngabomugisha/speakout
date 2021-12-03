package com.example.speakout.general

class Question (private var question_id:Int, private var question_date:String,
                private var question_poster:String,private var question_townhall:String,
                private var question_category:String, private var content:String)
{
    private var question_status:Int?=null;
    init
    {
        question_status=1
    }

    fun getQuestionId()=question_id
    fun getPosterId()=question_poster
    fun getDate()=question_date
    fun getTownhall()=question_townhall
    fun getCategory()=question_category
    fun getStatus()=question_status
    fun getContent()=content

    override fun toString(): String
    {
        return "id:$question_id, Poster:$question_poster, Townhall: $question_townhall"
    }

}