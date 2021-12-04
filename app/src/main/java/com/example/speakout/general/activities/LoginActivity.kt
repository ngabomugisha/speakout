package com.example.speakout.general.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.speakout.R
import com.example.speakout.content_provider.DatabaseConnection
import com.example.speakout.databinding.ActivityLoginBinding
import com.example.speakout.databinding.ActivitySignUpBinding
import com.example.speakout.general.classess.User
import com.example.speakout.organizer.activities.OrganizerDashboardActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class LoginActivity : AppCompatActivity() {
    private lateinit var andrew_id_login_id: EditText
    private lateinit var password: EditText
    private lateinit var binding: ActivityLoginBinding
//    private lateinit var bindingSignUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        andrew_id_login_id=binding.andrewIdLoginId
        password=binding.passwordLoginId

        val login=binding.loginBtnId
        login.setOnClickListener {
//            loginBtnClicked()
            saveSession()//save andrew id on the first login
        }

    }

    private fun loginBtnClicked()
    {
        val intent: Intent = Intent(this, OrganizerDashboardActivity::class.java)
        startActivity(intent)
    }

    private fun saveSession()
    {
        val andrew=andrew_id_login_id.text.toString()
        val pass=password.text.toString()
        var database=DatabaseConnection.connect()
        val user_reference=database.child("user/$andrew")
        user_reference?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    val andrew_id:String = snapshot.child("andrew_id").value.toString()
                    val fname:String= snapshot.child("firstname").value.toString()
                    val lname:String= snapshot.child("lastname").value.toString()
                    val password:String=snapshot.child("password").value.toString()
                    val role:String=snapshot.child("role").value.toString()

                    var user=User(andrew,password,fname,lname)
                    user.setRole(role)
                    Toast.makeText(this@LoginActivity,"${user}",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(this@LoginActivity,"Invalid details",Toast.LENGTH_LONG).show()
                }
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })


//        if(user==null)
//        {
//            Toast.makeText(this@LoginActivity,"Invalid details",Toast.LENGTH_LONG).show()
//        }
//        else
//        {
//            Toast.makeText(this@LoginActivity,"Very True",Toast.LENGTH_LONG).show()
//            Toast.makeText(this@LoginActivity,"Very True",Toast.LENGTH_LONG).show()
//            val sharedPreferences: SharedPreferences =
//                getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//            editor.apply {
//                putString("ANDREW_ID", user?.getAndrew())
//                putString("ROLE",user?.getRole())
//            }.apply()
//            Toast.makeText(this, user?.getAndrew() + "Login Saved for ever", Toast.LENGTH_SHORT)
//                .show()
//        }
    }
}