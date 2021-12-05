package com.example.speakout.general.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.speakout.R
import com.example.speakout.content_provider.DatabaseConnection
import com.example.speakout.databinding.ActivitySignUpBinding
import com.example.speakout.design_patterns.factory.DashboardFactory
import com.example.speakout.general.classess.User
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
/**
 * SignupActivity.kt is enabling new users to sign up
 *
 * @author GeekPrideSoft (Maurice, Robert, Jean Paul, Venant)
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized
 * assistance on this work.
 *
 */
class SignUpActivity : AppCompatActivity() {
    private lateinit var andrew_id_signup: TextInputEditText
    private lateinit var password_signup: TextInputEditText
    private lateinit var firstname: TextInputEditText
    private lateinit var lastname: TextInputEditText
    private lateinit var signup_btn: Button
    private lateinit var binding: ActivitySignUpBinding
    private var database:DatabaseReference?=null
    private var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database= DatabaseConnection.connect()
        andrew_id_signup=binding.andrewIdSignup
        password_signup=binding.passwordSignup
        firstname=binding.firstNameSignup
        lastname=binding.lastNameSignup
        signup_btn=binding.signupSignupBtnId
        updateCount()
        signup_btn.setOnClickListener {
            if (signUpValidate())
            {
                signupBtnClicked()
            }
        }
        val login=binding.loginSignupBtnId
        login.setOnClickListener {
            loginClicked()
        }

    }

    private fun loginClicked() {
        val intent:Intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }

    private fun signupBtnClicked()
    {
        val userId=andrew_id_signup.text.toString()
        val pass=password_signup.text.toString()
        val fname=firstname.text.toString()
        val lname=lastname.text.toString()
        var user:User=User("$userId","$pass","$fname","$lname")
        database?.child("user/$userId")?.setValue(user)
        val intent:Intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)

    }

    private fun signUpValidate(): Boolean
    {
        val uid:String=andrew_id_signup!!.text.toString()
        val fn:String=firstname!!.text.toString()
        val pwd:String=password_signup!!.text.toString()
        val ln:String=lastname!!.text.toString()

        if(uid.trim().isEmpty() || fn.trim().isEmpty() || pwd.trim().isEmpty() || ln.trim().isEmpty())
        {
            Toast.makeText(this@SignUpActivity, "All fields are required!", Toast.LENGTH_LONG)
                .show()
            return false
        }
        return true;
    }



    private fun updateCount()
    {
        database?.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists())
                {
                    count= snapshot.child("user").childrenCount.toInt()
                }
                count++
            }

            override fun onCancelled(error: DatabaseError) {

            }
        });
    }

}