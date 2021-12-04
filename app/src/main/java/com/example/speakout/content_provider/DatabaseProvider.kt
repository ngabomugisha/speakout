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
        var user_reference=database.child("user/$andrew")
        var user:User?=null
        user_reference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    val andrew:String = snapshot.child("andrew").value.toString()
                    val fname:String=snapshot.child(" firstname").value.toString()
                    val lname:String=snapshot.child("lastname").value.toString()
                    val password:String=snapshot.child(" password").value.toString()
                    val role:String=snapshot.child(" role").value.toString()
                    user=User(andrew,fname,lname,password)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return user
    }

}