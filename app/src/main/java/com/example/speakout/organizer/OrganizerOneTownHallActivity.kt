package com.example.speakout.organizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R

class OrganizerOneTownHallActivity : AppCompatActivity() {
    private var recycler: RecyclerView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizer_one_town_hall)

        recycler=findViewById<RecyclerView>(R.id.organizer_questions_recy_vw_id)
        val questions:ArrayList<QuestionClass> = ArrayList();
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
            questions.add(QuestionClass("Can we have a pool",p,"2021-3-7","20"))
        }

        val adapter= ReadQuestionAdapter(questions);
        recycler?.adapter=adapter
    }
}