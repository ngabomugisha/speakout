package com.example.speakout.general.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentManager
import com.example.speakout.organizer.fragments.ViewQuestionsFragment

/**
 * OrganizerOneTownHallActivity.kt is an activity for town hall organizer
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
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