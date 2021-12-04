package com.example.speakout.content_provider

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseConnection
{
    companion object
    {
        var provider:DatabaseProvider=DatabaseProvider()

        fun connect():DatabaseReference
        {
            var database: DatabaseReference? = null
            database = FirebaseDatabase.getInstance().getReference("speak_out")
            return database
        }

        fun databaseProvider(): DatabaseProvider
        {
            return provider
        }
    }
}