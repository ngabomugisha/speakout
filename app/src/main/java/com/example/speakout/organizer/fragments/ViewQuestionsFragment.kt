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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ViewQuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ViewQuestionsFragment : Fragment() {
    private var recycler: RecyclerView?=null;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler= activity?.findViewById<RecyclerView>(R.id.organizer_questions_recy_vw_id)
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