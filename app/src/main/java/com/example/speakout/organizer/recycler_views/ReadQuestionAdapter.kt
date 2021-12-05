package com.example.speakout.organizer.recycler_views

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.general.fragments.ViewTownHallsFragment
import com.example.speakout.organizer.classes.QuestionClass

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.speakout.organizer.fragments.Fragment_comment
import android.R
import androidx.core.content.ContentProviderCompat.requireContext

import androidx.fragment.app.FragmentActivity
import com.example.speakout.student.fragments.PostQuestionFragment


class ReadQuestionAdapter(private var questions: ArrayList<QuestionClass>
,private var listener:QuestionOnClick) :
    RecyclerView.Adapter<ReadQuestionAdapter.ReadQuestionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadQuestionHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(com.example.speakout.R.layout.organizer_questions_vw_card, parent,false);
        return ReadQuestionHolder(view);
    }
    override fun getItemCount(): Int {
        return this.questions.size;
    }

    override fun onBindViewHolder(
        holder: ReadQuestionHolder,
        position: Int
    ) {
        holder.bind(questions[position])
    }

    inner class ReadQuestionHolder (itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var quest: TextView;
        private lateinit var poster: TextView;
        private lateinit var num: TextView
        private lateinit var date: TextView
        private lateinit var comment: TextView
        init {
            itemView.setOnClickListener(this)
        }
        fun bind(question: QuestionClass) {
            quest = itemView.findViewById<TextView>(com.example.speakout.R.id.asked_question_id)
            poster =
                itemView.findViewById<TextView>(com.example.speakout.R.id.question_asker_org_id)
            num = itemView.findViewById<TextView>(com.example.speakout.R.id.comm_num_id)
            date = itemView.findViewById<TextView>(com.example.speakout.R.id.date_asked)

            comment = itemView.findViewById<TextView>(com.example.speakout.R.id.btn_comment)
            comment.setOnClickListener {
                Log.d("&&&&&&&&&&&&&77", "comment clicked"+itemView.toString())
//                startFragment(itemView)
            }
            quest.text = question.getQuestion();
            poster.text = question.getPoster()
            num.text = question.getNumberOfComments()
            date.text = question.getDate()
        }

        override fun onClick(v: View?) {
            val position=adapterPosition
            if (position != RecyclerView.NO_POSITION)
            {
                listener.questionOnClick(position)
            }
        }
    }
    fun upvoteQuestion(index: Int) {
//        Toast.makeText(requireContext(),"flsfnsdgmszldgzsdf $index",Toast.LENGTH_LONG).show()
        Log.d("**********", "swiped")
//        notifyDataSetChanged()
    }

    interface  QuestionOnClick
    {
        fun questionOnClick(position: Int)
    }
}
