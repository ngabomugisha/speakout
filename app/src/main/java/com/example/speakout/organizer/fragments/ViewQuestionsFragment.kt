package com.example.speakout.organizer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.QuestionClass
import com.example.speakout.organizer.recycler_views.ReadQuestionAdapter
import com.example.speakout.content_provider.DatabaseConnection
import com.example.speakout.organizer.classes.TownHallViewClass
import com.example.speakout.organizer.recycler_views.RecyclerViewTownHallAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

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
        var question_reference=database?.child("question")
        var poster_reference=database?.child("user")
        question_reference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    var questions=snapshot.children
                    var i=0
                    val all_questions:ArrayList<QuestionClass> = ArrayList();
                    questions.forEach{
                        if(i!=0)
                        {
                            val question_id=it.child("questionId").value.toString()
                            val content=it.child("content").value.toString()
                            val date=it.child("date").value.toString()
                            val poster=it.child("posterId").value.toString()
                            val num_count=2
                            all_questions.add(QuestionClass("$content","$poster","$date","$num_count"))
                        }
                        i++
                    }
                    val adapter= ReadQuestionAdapter(all_questions);
                    recycler?.adapter=adapter
                }
                else
                {
                    Toast.makeText(context,"Apana here",Toast.LENGTH_LONG).show()
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(context, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
    }

}