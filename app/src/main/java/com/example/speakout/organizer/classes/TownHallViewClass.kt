package com.example.speakout.organizer.classes

class TownHallViewClass(private var id:String, private var name:String, private var date:String)
{
    fun getName()=name;
    fun getDate()=date;
    fun getId()=id

    fun setId(i:String)
    {
        id=i;
    }
}