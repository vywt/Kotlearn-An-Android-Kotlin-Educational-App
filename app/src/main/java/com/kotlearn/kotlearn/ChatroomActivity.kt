package com.kotlearn.kotlearn

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chatroom.*

class ChatroomActivity : AppCompatActivity() {

    private var firebaseDatabase = FirebaseDatabase.getInstance()
    var user : FirebaseUser? = FirebaseAuth.getInstance().currentUser
    lateinit var dbRef : DatabaseReference;
    lateinit var messagesList : ArrayList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatroom)
        dbRef = firebaseDatabase.getReference("messages")
        var layoutManagerLinear = LinearLayoutManager(this)
        layoutManagerLinear.stackFromEnd = true
        rvMessages.layoutManager = layoutManagerLinear
        messagesList = ArrayList<Message>()

            //Init the listener
            val chatroomListener = object : ValueEventListener{

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    messagesList.clear()
                    dataSnapshot.children.mapNotNullTo(messagesList) { it.getValue<Message>(Message::class.java) }
                    rvMessages.scrollToPosition(messagesList.size - 1)
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    println("loadPost:onCancelled ${databaseError.toException()}")
                }
            }

            dbRef.addValueEventListener(
                    chatroomListener
            )


        rvMessages.adapter = MessageAdapter(messagesList,this)

            val sendBtn = findViewById<Button>(R.id.sendBtn)
            var et = findViewById<EditText>(R.id.msgEt)

            sendBtn.setOnClickListener {
                if (!et.toString().isEmpty()){
                    var message = Message(et.text.toString())
                    message.user = user?.email!!.split("@")[0]

                    var key = firebaseDatabase.getReference("messages").push().key
                    dbRef.child(key).setValue(message)
                    et.setText("")

                }else{
                    Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

