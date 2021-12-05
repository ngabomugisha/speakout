package com.example.speakout

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.speakout.databinding.ActivityMainBinding
import com.example.speakout.design_patterns.factory.DashboardFactory
import com.example.speakout.general.activities.SignUpActivity
import com.example.speakout.general.fragments.OrganizerOneTownHallActivity
import com.example.speakout.student.activities.ViewQuestionsStudentActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      Check if the user already exist and redirect them to their dashboard respectively
        checkPreferences()
    }

    override fun onResume() {
        super.onResume()
        checkPreferences()
    }
    private fun checkPreferences()
    {
        val sp: SharedPreferences =getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedAndrewId:String?=sp.getString("ANDREW_ID", null)
        val savedRole: String? =sp.getString("ROLE", null)
        if(savedAndrewId!=null)
        {
//            Toast.makeText(this,"$savedRole", Toast.LENGTH_SHORT).show()
            startActivity(DashboardFactory.decideDashboard(this,"$savedRole")?.goToDashboard())
        }
        else
        {
//            startActivity(DashboardFactory.decideDashboard(this,"student")?.goToDashboard())
//            signup first if you are new here
            val intent:Intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun postClicked()
    {
        val intent:Intent= Intent(this,ViewQuestionsStudentActivity::class.java)
        startActivity(intent)
    }

    private fun questionClicked()
    {
        val intent:Intent=Intent(this, OrganizerOneTownHallActivity::class.java)
        startActivity(intent)
    }

}