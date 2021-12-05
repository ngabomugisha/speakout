package com.example.speakout.general.classess

/**
 * Question.kt is a class for Question
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class Question (private var question_date:String,
                private var question_poster:String,private var question_townhall:String,
                private var question_category:String, private var content:String)
{
    private var question_status:Int?=null;
    private var question_id:Int?=null;
    private var parent:Int?=null;
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
    fun getParent()=parent

    fun setId(id:Int)
    {
        question_id=id
    }
    fun setStatus(i:Int)
    {
        question_status=i
    }
    fun setParent(p:Int?)
    {
        parent=p
    }

    override fun toString(): String
    {
        return "id:$question_id, Poster:$question_poster, Townhall: $question_townhall"
    }

}