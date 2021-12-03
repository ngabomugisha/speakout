package com.example.speakout.utils

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseConnection
{
    companion object
    {
        fun connect():DatabaseReference
        {
            var database: DatabaseReference? = null
            database = FirebaseDatabase.getInstance().getReference("speak_out")
            return database
        }
    }
}