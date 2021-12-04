package com.example.speakout.content_provider.DBHelper

import com.example.speakout.content_provider.DatabaseConnection
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class DBCount
{
    companion object
    {
        fun countQuestions(database:DatabaseReference):Int
        {
            var count=0

            database?.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    if(snapshot.exists())
                    {
                        count= snapshot.child("question").childrenCount.toInt()
                    }
                    count++
                }

                override fun onCancelled(error: DatabaseError) {

                }
            })

            return count+1
        }
    }
}