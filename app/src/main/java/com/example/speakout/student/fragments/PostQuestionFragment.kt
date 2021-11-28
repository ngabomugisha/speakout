package com.example.speakout.student.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R

class PostQuestionFragment : DialogFragment() {

    var post_question_id: Button?= null
    var post_question_close : Button?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_post_question, container, false)
        closeDialog(rootView)
        CreatePost(rootView)
        return rootView
    }

    fun closeDialog (rootView: View) {

        post_question_close = rootView.findViewById(R.id.post_question_close)
        post_question_close?.setOnClickListener {
            dismiss()
        }
    }
    fun CreatePost (rootView: View) {

        post_question_id = rootView.findViewById(R.id.post_question_id)
        post_question_id?.setOnClickListener {
            Toast.makeText(context, "Create Post  ", Toast.LENGTH_LONG).show()
        }
    }


}