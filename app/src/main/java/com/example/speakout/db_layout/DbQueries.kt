package com.example.speakout.db_layout

open abstract class DbQueries
{
    private var data:LinkedHashMap<String,String>?=null
    abstract fun doQuery()
    fun setData(d:LinkedHashMap<String,String>)
    {
        data=d;
    }
    fun getData()=data

    override fun toString(): String {
        return "Data available are $data"
    }
}