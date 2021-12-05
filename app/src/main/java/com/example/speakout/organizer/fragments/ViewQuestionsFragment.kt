package com.example.speakout.organizer.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.speakout.R
import com.example.speakout.organizer.classes.QuestionClass
import com.example.speakout.organizer.recycler_views.ReadQuestionAdapter
import com.example.speakout.content_provider.DatabaseConnection
<<<<<<< Updated upstream
import com.example.speakout.design_patterns.factory.DashboardFactory
import com.example.speakout.organizer.recycler_views.SwipeToUpvoteCallback
import com.example.speakout.student.activities.StudentDashboard
import com.example.speakout.student.fragments.PostQuestionFragment
=======
import com.example.speakout.organizer.classes.MaxHeap
import com.example.speakout.organizer.recycler_views.SwipeToUpvoteCallback
import com.example.speakout.utils.Helper
>>>>>>> Stashed changes
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class ViewQuestionsFragment : Fragment(), ReadQuestionAdapter.QuestionClickInterface {
    private var recycler: RecyclerView?=null;
    private var database:DatabaseReference?=null;
    private var townhall_id:String=""
    private var number:String=""
    private val all_questions:ArrayList<QuestionClass> = ArrayList();
    var sp: SharedPreferences?=null
    var savedAndrewId:String?=null
    var savedRole: String? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // connecting to database
        database= DatabaseConnection.connect()
        townhall_id= this.arguments?.getString("townhall_id").toString()
        number=this.arguments?.getString("number").toString()

        sp=activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        savedAndrewId=sp?.getString("ANDREW_ID", null)
        savedRole =sp?.getString("ROLE", null)
        Toast.makeText(context,"$savedRole",Toast.LENGTH_LONG).show()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        recycler= activity?.findViewById<RecyclerView>(R.id.organizer_questions_recy_vw_id)
       getQuestions()
    }

    private fun getQuestions()
    {
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    var questions=snapshot.child("question").children
                    var users=snapshot.child("user")
                    var i=0
                    all_questions.clear()
                    var heap: MaxHeap=MaxHeap();
                    questions.forEach{
                        if(i!=0)
                        {
                            val townhall=it.child("townhall").value.toString()
                            if(townhall==townhall_id)
                            {
                                val question_id=it.child("questionId").value.toString()
                                val content=it.child("content").value.toString()
                                val date=it.child("date").value.toString()
                                val poster=it.child("posterId").value.toString()
                                var poster_name=users.child("$poster").child("firstName").value.toString()
                                val num_count=it.child("votes").childrenCount
                                val votes=it.child("votes").childrenCount
                                heap.insert(QuestionClass("$question_id","$content","$poster_name","$date","11","$votes"))
                                all_questions.add(QuestionClass("$question_id","$content","$poster_name","$date","11","$votes"))
                            }
                        }
                        i++
                    }
                    var adapter=ReadQuestionAdapter(all_questions,this@ViewQuestionsFragment)
                   if(savedRole=="organizer")
                    {
                        adapter = ReadQuestionAdapter(heap.get(Helper.toInteger(number)), this@ViewQuestionsFragment)
                        recycler?.adapter=adapter
                        adapter.notifyDataSetChanged()
                   }
                    if(savedRole=="student")
                    {
                        adapter = ReadQuestionAdapter(heap.get(Helper.toInteger(number)), this@ViewQuestionsFragment)
                        recycler?.adapter=adapter
                        adapter.notifyDataSetChanged()
                    }



                    val swipeUpvote = object : SwipeToUpvoteCallback(requireContext()){
                        override fun onSwiped(
                            viewHolder: RecyclerView.ViewHolder,
                            direction: Int
                        ) {
                            adapter.upvoteQuestion(viewHolder.adapterPosition)
                            // Using a content provider, vote
                            val sp: SharedPreferences? =activity?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                            val savedAndrewId:String?=sp?.getString("ANDREW_ID", null)
                            val savedRole:String?=sp?.getString("ROLE", null)
                            if(savedRole=="student")
                            {
                                DatabaseConnection.databaseProvider().voteQuestion(
                                    "$savedAndrewId",
                                    "${all_questions.get(viewHolder.adapterPosition).getId()}",
                                    1
                                )
                                Toast.makeText(context, "Voted", Toast.LENGTH_LONG).show()
                            }
                            else
                            {
                                Toast.makeText(context, "You are an organizer", Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    val touchHelper  = ItemTouchHelper(swipeUpvote)
                        touchHelper.attachToRecyclerView(this@ViewQuestionsFragment.recycler)
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
    private fun startPostFragments()
    {
        var bundle:Bundle= Bundle()
        bundle.putString("townhall_id",townhall_id)
        val fragment:Fragment= Fragment_comment()
        fragment.arguments=bundle
        val manager: FragmentManager = requireActivity().supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.setReorderingAllowed(true)
        transaction.add(com.example.speakout.R.id.view_question_fragment_id, fragment,null)
        transaction.commit()
    }
    //organizer_questions_recy_vw_id organizer_questions_recy_vw_id
    override fun questionOnClick(position: Int)
    {
//        var intent= Intent(activity, StudentDashboard::class.java)
//        startActivity(intent)
        var fragment = Fragment_comment()
        var bundle:Bundle= Bundle()
        bundle.putString("townhall_id",townhall_id)
        fragment.arguments=bundle
        fragment.show(requireActivity().supportFragmentManager, "DialogFragment")

    }

}