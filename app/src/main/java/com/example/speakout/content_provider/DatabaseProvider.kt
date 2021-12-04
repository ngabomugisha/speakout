package com.example.speakout.content_provider

import android.widget.Toast
import com.example.speakout.general.classess.Question
import com.example.speakout.general.classess.Townhall
import com.example.speakout.utils.Helper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

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

    override fun selectTownHalls()
    {
        TODO("Not yet implemented")
    }

    override fun selectQuestion()
    {
        TODO("Not yet implemented")
    }

    override fun selectComments(question: Int)
    {
        TODO("Not yet implemented")
    }

    override fun selectUser(andrew: String, password: String)
    {
        TODO("Not yet implemented")
    }

}