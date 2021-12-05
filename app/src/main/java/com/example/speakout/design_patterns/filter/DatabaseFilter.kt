package com.example.speakout.design_patterns.filter

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference

interface DatabaseFilter
{
    fun meetPath(snapshot: DataSnapshot, path:String):String
}