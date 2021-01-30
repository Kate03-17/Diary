package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {

    private lateinit var signUpEmail: EditText
    private lateinit var signUpPassword: EditText
    private lateinit var signUpButton: Button
    private lateinit var registerButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        mAuth = FirebaseAuth.getInstance()

        signUpEmail = findViewById(R.id.signUpEmailEditText)
        signUpPassword = findViewById(R.id.signUpPasswordEditText)
        signUpButton = findViewById(R.id.signUpButton)
        registerButton = findViewById(R.id.goToRegistrationButton)

        signUpButton.setOnClickListener {

            val email = signUpEmail.text.toString()
            val password = signUpPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty parameter!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { Task ->
                        if(Task.isSuccessful){
                            startActivity(Intent(this, MainActivity :: class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                        }
                    }
            }

        }

        registerButton.setOnClickListener {
            startActivity(Intent(this, MainActivity :: class.java))
        }
    }
}