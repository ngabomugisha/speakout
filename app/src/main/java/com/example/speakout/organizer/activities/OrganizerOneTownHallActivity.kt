package com.example.speakout.organizer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.QuestionClass
import com.example.speakout.organizer.recycler_views.ReadQuestionAdapter

/**
 * OrganizerOneTownHallActivity.kt is an activity for one town hall organizer
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class OrganizerOneTownHallActivity : AppCompatActivity(),ReadQuestionAdapter.QuestionClickInterface {
    private var recycler: RecyclerView?=null;
    private var lay:Layout?=null;
    val questions:ArrayList<QuestionClass> = ArrayList();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer_one_town_hall)

        recycler=findViewById<RecyclerView>(R.id.organizer_questions_recy_vw_id)
        var p:String?=null;
        for (i in 1..30)
        {
            if(i%2==0)
            {
                p="Robert"
            }
            else if(i%3==0)
            {
                p="Venant"
            }
            else
            {
                p="Maurice"
            }
            questions.add(QuestionClass("1","Can we have a pool",p,"2021-3-7","20","4"))
        }

//        val adapter= ReadQuestionAdapter(questions,t);
//        recycler?.adapter=adapter
    }

    override fun questionOnClick(position: Int) {
        Toast.makeText(this,"Here is clicked",Toast.LENGTH_LONG).show()
    }
}