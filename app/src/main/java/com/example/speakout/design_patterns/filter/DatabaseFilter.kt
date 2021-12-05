package com.example.speakout.design_patterns.filter

import com.google.firebase.database.DatabaseReference

interface DatabaseFilter
{
    fun meetPath(path:String):DatabaseReference
}