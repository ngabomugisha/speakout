package com.example.speakout.content_provider

import com.example.speakout.general.classess.Question
import com.example.speakout.general.classess.Townhall
import com.example.speakout.utils.Helper
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class DatabaseProvider:Insert,Select
{
    private var database:DatabaseReference= DatabaseConnection.connect()

    // Recording a new townhall in database
    override fun insertTownHall(townhall: Townhall)
    {
        var count=0
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    count= snapshot.child("townhall").childrenCount.toInt()
                }
                count++
                // Inserting via a content provider
//                DatabaseConnection.databaseProvider().insertTownHall(townhall)
                townhall.setCount(count)
                database?.child("townhall/${townhall.getTownhallId()}")?.setValue(townhall)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
       //database?.child("townhall/${townhall.getTownhallId()}")?.setValue(townhall)
    }

    override fun insertQuestion(question: Question)
    {
        TODO("Not yet implemented")
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