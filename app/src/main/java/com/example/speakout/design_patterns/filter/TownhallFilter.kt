package com.example.speakout.design_patterns.filter

import com.example.speakout.content_provider.DatabaseConnection
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference

class TownhallFilter:DatabaseFilter
{
    override fun meetPath(snapshot: DataSnapshot, path: String):String
    {
        return snapshot.child("townhall/$path").toString()
    }
}