package com.example.speakout.general.classess

import java.util.*

/**
 * Townhall.kt is a class for Townhall.
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class Townhall(private var townhall_id:String, private var startDate:String,
private var endDate:String, private var live_date:String,
private var status:Int=1, private var organizer_id:String, private var details:String)
{
    private var townhall_count:Int=0
    // getters
    fun getTownhallId()=townhall_id
    fun getStartDate()=startDate
    fun getEndDate()=endDate
    fun getLiveDate()=live_date
    fun getStatus()=status
    fun getOrganizerId()=organizer_id
    fun getDetails()=details
    fun getCount()=townhall_count

    // setters
    fun setTownhallId(id:String)
    {
        townhall_id=id
    }

    fun setCount(c:Int)
    {
        townhall_count=c
    }
    fun setStartDate(d:String)
    {
        startDate=d
    }
    fun setEndDate(d:String)
    {
        endDate=d
    }
    fun setLiveDate(d:String)
    {
        live_date=d
    }
    fun setStatus(s:Int)
    {
        status=s
    }
    fun setOrganizerId(o:String){
        organizer_id=o
    }
    fun setDetails(d:String):String
    {
        return details
    }

    override fun toString(): String
    {
        return "id: $townhall_id; start: $startDate; end: $endDate; live: $live_date; organizer: $organizer_id"
    }
}