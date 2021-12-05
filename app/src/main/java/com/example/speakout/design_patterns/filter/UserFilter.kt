package com.example.speakout.design_patterns.filter

import com.example.speakout.content_provider.DatabaseConnection
import com.google.firebase.database.DatabaseReference

class UserFilter: DatabaseFilter
{
    override fun meetPath(path: String): DatabaseReference
    {
        return DatabaseConnection.connect().child("user/$path")
    }

}