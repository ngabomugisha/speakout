package com.example.speakout.organizer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.speakout.R
import com.example.speakout.content_provider.DatabaseConnection
import com.google.android.material.textfield.TextInputEditText

import com.example.speakout.general.classess.Townhall
import com.example.speakout.organizer.classes.SelectDateFragment
import com.example.speakout.utils.Helper

import com.google.firebase.database.*


class CreateTownHallFragment : DialogFragment()
{
    private var date:TextView?=null;
    private var start:TextView?=null;
    private var end:TextView?=null;
    private var details:TextInputEditText?=null;
    private var count:Int=0;

    private var town_hall_close_btn_id:Button?= null
    private var town_hall_create_btn_id:Button?= null
    private var database: DatabaseReference? = null

    private var newFragment: DialogFragment?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        database = FirebaseDatabase.getInstance().getReference("speak_out")
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_create_town_hall, container, false)
        setInputFields(rootView)
        updateCount()
        creat_Town_Hall(rootView)
        closeDialog(rootView)

        // handling select dates
        dateClicked()
        selectStartDate()
        selectEndDate()

        return rootView
    }

    private fun updateCount()
    {
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    count= snapshot.child("townhall").childrenCount.toInt()
                }
                count++
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    private fun setInputFields(rootView: View?)
    {
        date=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_date_id)
        start=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_start_date_id)
        end=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_end_date_id)
        details=rootView!!.findViewById<TextInputEditText>(R.id.town_hall_details_id)
    }

    fun closeDialog (rootView: View) {

        town_hall_close_btn_id = rootView.findViewById(R.id.town_hall_close_btn_id)
        town_hall_close_btn_id?.setOnClickListener {
            dismiss()
        }
    }
    private fun creat_Town_Hall(rootView: View) {
        town_hall_create_btn_id = rootView.findViewById(R.id.town_hall_start_btn_id)
        town_hall_create_btn_id?.setOnClickListener {
            if (!fieldsValidate())
            {

            }
            else
            {
                var d:String=date!!.text.toString()
                val s:String=Helper.changeDate(start!!.text.toString())
                val e:String=Helper.changeDate(end!!.text.toString())
                val det:String=details!!.text.toString()
                var id=Helper.changeDate(d)
                d=Helper.changeDate(d)

                val townhall: Townhall = Townhall(id,s,e,d,1,"001",det)
                townhall.setCount(count)
                // Inserting via a content provider
                DatabaseConnection.databaseProvider().insertTownHall(townhall)

                Toast.makeText(context,"Townhall saved successfully",Toast.LENGTH_LONG).show()
                dismiss()
            }
        }
    }

    private fun fieldsValidate(): Boolean
    {
        val d:String=date!!.text.toString()
        val s:String=start!!.text.toString()
        val e:String=end!!.text.toString()
        val det:String=details!!.text.toString()

        if(d.trim().isEmpty() || s.trim().isEmpty() || e.trim().isEmpty() || det.trim().isEmpty())
        {
            Toast.makeText(context, "Please, all fields are required", Toast.LENGTH_LONG)
            .show()
            return false
        }
        else if(2==3) // replace this to date start date, and end date validation
        {
            return false
        }
        return true;
    }

    private fun clickDatePicker(view:View, a:String)
    {
        newFragment = SelectDateFragment()
        (newFragment as SelectDateFragment).show(requireFragmentManager(), "DatePicker")
        (view as TextView).text = (newFragment as SelectDateFragment).getDate()
        (newFragment as SelectDateFragment).setRootView(view)
        (newFragment as SelectDateFragment).setTextView(a)
    }

    // When Town_hall date is clicked, the following codes allows to select the date
    private fun dateClicked()
    {
        date!!.setOnClickListener { view->
            clickDatePicker(view,"date")
        }
    }

    // When start date is clicked, the following codes allows to select the date
    private fun selectStartDate()
    {
        start!!.setOnClickListener { view->
            clickDatePicker(view, "start")
        }
    }

    // When end date is clicked, the following codes allows to select the date
    //Validating ending data
    private fun selectEndDate()
    {
        end!!.setOnClickListener { view->
            clickDatePicker(view, "end")
        }
    }
}

private fun DatabaseReference?.addChildEventListener(valueEventListener: ValueEventListener) {

}
