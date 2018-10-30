package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth;
    private lateinit var emailAdd : String;
    private lateinit var password : String;

    override fun onStart(){
        super.onStart()
        var currentUser : FirebaseUser? = mAuth.getCurrentUser()
        updateUI(currentUser);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        val loginBtn = findViewById<Button>(R.id.btnLogin)
        loginBtn.setOnClickListener {
            emailAdd = findViewById<EditText>(R.id.emailText).text.toString()
            password = findViewById<EditText>(R.id.password).text.toString()

            tryLogin(emailAdd, password)
        }

        val registerBtn = findViewById<Button>(R.id.btnRegister)
        registerBtn.setOnClickListener {
            emailAdd = findViewById<EditText>(R.id.emailText).text.toString()
            password = findViewById<EditText>(R.id.password).text.toString()

            tryRegister(emailAdd, password)
        }

    }

    fun updateUI(firebaseUser : FirebaseUser?){
        if (firebaseUser != null){
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        } else {

        }
    }

    fun tryLogin(emailAdd: String, password: String){
        if (emailAdd == "" || password == ""){
            Toast.makeText(this, "Empty Email/Password Not Acceptable!", Toast.LENGTH_SHORT).show()
            return
        }

        mAuth.signInWithEmailAndPassword(emailAdd, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "Logged in Successfully", Toast.LENGTH_SHORT).show()
                        val user = mAuth.currentUser
                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }

                }
    }

    fun tryRegister(emailAdd: String, password: String){
        if (emailAdd == "" || password == ""){
            Toast.makeText(this, "Empty Email/Password Not Acceptable!", Toast.LENGTH_SHORT).show()
            return
        }
        mAuth.createUserWithEmailAndPassword(emailAdd, password).
                addOnCompleteListener(this, OnCompleteListener {
                    if (it.isSuccessful) {
                        var user : FirebaseUser? = mAuth.currentUser
                        updateUI(user)
                    } else {
                        Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
                )
    }

}
