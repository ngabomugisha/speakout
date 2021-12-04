package com.example.speakout.general.classess

class User(private var andrew:String, private var password:String,private var firstname:String, private var lastname:String)
{
    private var role:String?=null
    private var status:Int?=null
    init
    {
      status=1
      role=" student"
    }

    fun getAndrew()=andrew
    fun getPassword()=password
    fun getFirstName()=firstname
    fun getLastName()=lastname
    fun getRole()=role

    fun setRole(r:String)
    {
        role=r
    }

    override fun toString(): String
    {
        return "Andrew: $andrew, LastName: $lastname, Role: $role"
    }
}