package com.example.speakout.content_provider

import android.widget.Toast
import com.example.speakout.design_patterns.composite.CommentPattern
import com.example.speakout.general.classess.Question
import com.example.speakout.general.classess.Townhall
import com.example.speakout.general.classess.User
import com.example.speakout.organizer.classes.QuestionClass
import com.example.speakout.utils.Helper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

/**
 * DatabaseProvider.kt is enabling manipulating data from database.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class DatabaseProvider:Insert,Select, Update
{
    private var database:DatabaseReference= DatabaseConnection.connect()

    // Recording a new townhall in database
    override fun insertTownHall(townhall: Townhall)
    {
        database?.child("townhall/${townhall.getTownhallId()}")?.setValue(townhall)
    }

    override fun insertQuestion(question: Question)
    {
        database?.child("question/${question.getQuestionId()}")?.setValue(question)
    }

    override fun voteQuestion(voter: String, question: String, vote: Int)
    {
        database?.child("question/$question/votes/$voter").setValue("$vote")
    }

    override fun selectTownHalls()
    {
        TODO("Not yet implemented")
    }

    override fun selectQuestion(townhall:String, parent:Int):String
    {
       return ""
    }

    override fun selectComments(question: Int)
    {
       // stub
    }

    override fun selectUser(andrew: String, password: String): User?
    {
        TODO("Not yet implemented")
    }


}