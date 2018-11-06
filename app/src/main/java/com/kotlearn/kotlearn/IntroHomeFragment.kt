package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.kotlearn.kotlearn.LearnThroughTutorials.Intro1HelloWorldFragment
import com.kotlearn.kotlearn.LearnThroughVideos.LearnThroughVideoFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class IntroHomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_intro_home, container, false)
        val btnwords = rootview.findViewById<CardView>(R.id.learnthroughwords)
        val btnvideos = rootview.findViewById<CardView>(R.id.learnthroughvideos)
        val btnpractice = rootview.findViewById<CardView>(R.id.learnthroughpractice)
        val btnquestions = rootview.findViewById<CardView>(R.id.learnthroughquestions)
        val btncommunity = rootview.findViewById<CardView>(R.id.community)
        val btnabout = rootview.findViewById<CardView>(R.id.about)



        val fragmentManager = getFragmentManager()
        val transaction = fragmentManager!!.beginTransaction()

        btnwords.setOnClickListener {
            transaction.replace(R.id.fragmentUsed, Intro1HelloWorldFragment()).commit()
        }

        btnvideos.setOnClickListener {
            transaction.replace(R.id.fragmentUsed, LearnThroughVideoFragment()).commit()
        }

        btnpractice.setOnClickListener {
            transaction.replace(R.id.fragmentUsed, EditorFragment()).commit()
        }

        btnquestions.setOnClickListener {
            transaction.replace(R.id.fragmentUsed, QuizFragment()).commit()
        }

        btncommunity.setOnClickListener {
            var myintent = Intent(activity, ChatroomActivity::class.java)
            startActivity(myintent)
        }

        btnabout.setOnClickListener {
            transaction.replace(R.id.fragmentUsed, CreditsFragment()).commit()
        }


        return rootview
    }


}
