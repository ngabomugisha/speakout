package com.example.speakout.student.fragments

import android.content.Context
import android.content.SharedPreferences
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
import com.example.speakout.content_provider.DatabaseConnection
import com.example.speakout.content_provider.DatabaseProvider
import com.example.speakout.utils.Helper
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class PostQuestionFragment : DialogFragment()
{
    private var post_question_id: Button?= null
    private var post_question_close : Button?= null
    private var database: DatabaseReference? = null
    private var provider: DatabaseProvider? = null
    private var finance:RadioButton?=null
    private var sport:RadioButton?=null
    private var welfare:RadioButton?=null
    private var affair:RadioButton?=null
    private var question: TextInputEditText?=null
    private var category:String?=null;
    private var count:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // connect to the database
        database = DatabaseConnection.connect()
        provider= DatabaseConnection.databaseProvider()
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_post_question, container, false)
        initializeButtons(rootView)
        switchCategory()
        closeDialog()
        updateCount()
        CreatePost()
        return rootView
    }
    private fun closeDialog ()
    {
        post_question_close?.setOnClickListener {
            dismiss()
        }
    }

    private fun updateCount()
    {
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    count= snapshot.child("question").childrenCount.toInt()
                }
                count++
            }

            override fun onCancelled(error: DatabaseError) {

            }
        });
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
                val sp: SharedPreferences? =activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                val savedAndrewId:String?=sp?.getString("ANDREW_ID", null)
                val q: String? =question?.text.toString()
                val date: String =Helper.changeDate(Helper.todayDate())
                val saveQuestion: Question = Question("$date","$savedAndrewId"
                    ,"${Helper.changeDate(Helper.todayDate())}","$category","$q")
                saveQuestion.setId(count)
                saveQuestion.setParent(saveQuestion.getQuestionId())
                provider?.insertQuestion(saveQuestion)
                Toast.makeText(context,getString(R.string.success_msg),Toast.LENGTH_LONG).show()
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