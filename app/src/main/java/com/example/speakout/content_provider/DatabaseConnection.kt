package com.example.speakout.content_provider

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

/**
 * DatabaseConnection is connecting to the database
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
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