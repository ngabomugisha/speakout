package com.example.speakout.organizer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.QuestionClass
import com.example.speakout.organizer.recycler_views.ReadQuestionAdapter
import com.example.speakout.content_provider.DatabaseConnection
import com.google.firebase.database.DatabaseReference

class ViewQuestionsFragment : Fragment() {
    private var recycler: RecyclerView?=null;
    private var database:DatabaseReference?=null;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // connecting to database
        database= DatabaseConnection.connect()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler= activity?.findViewById<RecyclerView>(R.id.organizer_questions_recy_vw_id)
       getQuestions()
    }

    private fun getQuestions()
    {
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