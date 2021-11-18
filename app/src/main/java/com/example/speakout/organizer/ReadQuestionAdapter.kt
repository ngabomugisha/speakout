package com.example.speakout.organizer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import org.w3c.dom.Text

class ReadQuestionAdapter(private var questions: ArrayList<QuestionClass>) :
    RecyclerView.Adapter<ReadQuestionAdapter.ReadQuestionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadQuestionHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.organizer_questions_vw_card, parent,false);
        return ReadQuestionHolder(view);
    }
    override fun getItemCount(): Int {
        return this.questions.size;
    }

    override fun onBindViewHolder(
        holder: ReadQuestionAdapter.ReadQuestionHolder,
        position: Int
    ) {
        holder.bind(questions[position])
    }

    class ReadQuestionHolder (itemView: View): RecyclerView.ViewHolder(itemView)
    {
        private lateinit var quest: TextView;
        private lateinit var poster: TextView;
        private lateinit var num: TextView
        private lateinit var date: TextView
        fun bind(question : QuestionClass)
        {
            quest=itemView.findViewById<TextView>(R.id.asked_question_id)
            poster=itemView.findViewById<TextView>(R.id.question_asker_org_id)
            num=itemView.findViewById<TextView>(R.id.comm_num_id)
            date=itemView.findViewById<TextView>(R.id.date_asked)

            quest.text=question.getQuestion();
            poster.text=question.getPoster()
            num.text=question.getNumberOfComments()
            date.text=question.getDate()
        }
    }


}
