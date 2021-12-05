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

/**
 * MainActivity.kt is the main program
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
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

//    override fun onStop() {
//        super.onStop()
//        System.exit(0);
//    }
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
//            Toast.makeText(this,"not saved", Toast.LENGTH_SHORT).show()
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