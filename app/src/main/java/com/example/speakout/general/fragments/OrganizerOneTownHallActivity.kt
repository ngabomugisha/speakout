package com.example.speakout.general.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentManager
import com.example.speakout.organizer.fragments.ViewQuestionsFragment

class OrganizerOneTownHallActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.speakout.R.layout.activity_organizer_one_town_hall)

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(com.example.speakout.R.id.view_question_fragment_id,ViewQuestionsFragment::class.java,null)
        transaction.commit()
    }
}