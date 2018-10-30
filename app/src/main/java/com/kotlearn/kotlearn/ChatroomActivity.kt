package com.kotlearn.kotlearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class ChatroomActivity : AppCompatActivity() {

    private var firebaseDatabase = FirebaseDatabase.getInstance()
    var user : FirebaseUser? = FirebaseAuth.getInstance().currentUser
    lateinit var dbRef : DatabaseReference;
    lateinit var messagesList : MutableList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)

        initMessages()

        val sendBtn = findViewById<Button>(R.id.sendBtn)
        var et = findViewById<EditText>(R.id.msgEt)

        sendBtn.setOnClickListener {
            if (!et.toString().isEmpty()){
                var message = Message(et.text.toString())
                message.user = user?.email!!.split("@")[0]
                sendData(message)
                et.setText("")

            }else{
                Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
            }
        }






    }

    private fun initMessages(){
        dbRef = firebaseDatabase.getReference("messages")
        dbRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                println(error!!.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                messagesList = mutableListOf<Message>()
                snapshot.children.mapNotNullTo(messagesList) { it.getValue<Message>(Message::class.java)
                }
                println(messagesList[0].text + messagesList[0].text)

            }
        })
    }

    private fun sendData(message:Message){

        val chatroomListener = object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                messagesList = mutableListOf<Message>()
                dataSnapshot.children.mapNotNullTo(messagesList) { it.getValue<Message>(Message::class.java) }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                println("loadPost:onCancelled ${databaseError.toException()}")
            }
        }

        dbRef = firebaseDatabase.getReference("messages")
        dbRef.addValueEventListener(
                chatroomListener
        )
        var key = firebaseDatabase.getReference("messages").push().key
        dbRef.child(key).setValue(message)
    }
}
