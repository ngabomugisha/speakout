package com.example.speakout.student.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R
import com.example.speakout.general.classess.Question
import com.example.speakout.utils.DatabaseConnection
import com.example.speakout.utils.Helper
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference

class PostQuestionFragment : DialogFragment()
{
    private var post_question_id: Button?= null
    private var post_question_close : Button?= null
    private var database: DatabaseReference? = null
    private var finance:RadioButton?=null
    private var sport:RadioButton?=null
    private var welfare:RadioButton?=null
    private var affair:RadioButton?=null
    private var question: TextInputEditText?=null
    private var category:String?=null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // connect to the database
        database = DatabaseConnection.connect()
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_post_question, container, false)
        initializeButtons(rootView)
        switchCategory()
        closeDialog()
        CreatePost()
        return rootView
    }
    private fun closeDialog ()
    {
        post_question_close?.setOnClickListener {
            dismiss()
        }
    }
    private fun CreatePost ()
    {
        post_question_id?.setOnClickListener {
            if(!validateInput())
            {
                Toast.makeText(context,"Please all fields are required",Toast.LENGTH_LONG).show()
            }
            else
            {
                val q: String? =question?.text.toString()
                val date: String =Helper.changeDate(Helper.todayDate())
                val saveQuestion: Question = Question(1,"$date","001"
                    ,"11-4-2021","$category","$q")
                database?.child("question/${saveQuestion.getQuestionId()}")?.setValue(saveQuestion)
                Toast.makeText(context,"Your question is successfully posted",Toast.LENGTH_LONG).show()
                question?.setText("")
            }
        }
    }

    private fun initializeButtons(rootView: View?)
    {
        post_question_close = rootView?.findViewById(R.id.post_question_close)
        post_question_id = rootView?.findViewById(R.id.post_question_id)

        finance=rootView?.findViewById(R.id.finance_category_id)
        sport=rootView?.findViewById(R.id.sport_category_id)
        welfare=rootView?.findViewById(R.id.welness_category_id)
        affair=rootView?.findViewById(R.id.social_category_id)

        question=rootView?.findViewById<TextInputEditText>(R.id.question_content_id)

        category=finance?.text.toString()

    }

    private fun validateInput(): Boolean
    {
        val q: String? =question?.text.toString()
        if(q!!.trim()!!.isEmpty())
        {
            return false
        }
        return true
    }

    private fun switchCategory()
    {
        finance?.setOnClickListener {
            category=finance?.text.toString()
        }
        welfare?.setOnClickListener {
            category=welfare?.text.toString()
        }
        sport?.setOnClickListener {
            category=sport?.text.toString()
        }
        affair?.setOnClickListener {
            category=affair?.text.toString()
        }
    }

}