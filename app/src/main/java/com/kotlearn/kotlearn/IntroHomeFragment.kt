package com.kotlearn.kotlearn

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
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

        val wordsIcon = rootview.findViewById<ImageView>(R.id.learnthroughwords_image)
        wordsIcon.drawable.setColorFilter(Color.parseColor("#ffb3ba"), PorterDuff.Mode.MULTIPLY)


        val videosIcon = rootview.findViewById<ImageView>(R.id.learnthroughvideos_images)
        videosIcon.drawable.setColorFilter(Color.parseColor("#FA8072"), PorterDuff.Mode.MULTIPLY)


        val questionsIcon = rootview.findViewById<ImageView>(R.id.learnthroughquestions_image)
        questionsIcon.drawable.setColorFilter(Color.parseColor("#ffa500"), PorterDuff.Mode.MULTIPLY)


        val practiceIcon = rootview.findViewById<ImageView>(R.id.learnthroughpractice_image)
        practiceIcon.drawable.setColorFilter(Color.parseColor("#87CEFA"), PorterDuff.Mode.MULTIPLY)


        val communityIcon = rootview.findViewById<ImageView>(R.id.community_image)
        communityIcon.drawable.setColorFilter(Color.parseColor("#66cdaa"), PorterDuff.Mode.MULTIPLY)


        val aboutIcon = rootview.findViewById<ImageView>(R.id.about_image)
        aboutIcon.drawable.setColorFilter(Color.parseColor("#C0C0C0"), PorterDuff.Mode.MULTIPLY)



//        val wordsIcon = rootview.findViewById<ImageView>(R.id.learnthroughwords_image)
//        wordsIcon.drawable.setColorFilter(Color.parseColor("#87CEFA"), PorterDuff.Mode.MULTIPLY)
//
//        val videosIcon = rootview.findViewById<ImageView>(R.id.learnthroughvideos_images)
//        videosIcon.drawable.setColorFilter(Color.parseColor("#ffb3ba"), PorterDuff.Mode.MULTIPLY)
//
//
//        val questionsIcon = rootview.findViewById<ImageView>(R.id.learnthroughquestions_image)
//        questionsIcon.drawable.setColorFilter(Color.parseColor("#ffa500"), PorterDuff.Mode.MULTIPLY)
//
//        val practiceIcon = rootview.findViewById<ImageView>(R.id.learnthroughpractice_image)
//        practiceIcon.drawable.setColorFilter(Color.parseColor("#66cdaa"), PorterDuff.Mode.MULTIPLY)
//
//        val communityIcon = rootview.findViewById<ImageView>(R.id.community_image)
//        communityIcon.drawable.setColorFilter(Color.parseColor("#FA8072"), PorterDuff.Mode.MULTIPLY)
//
//
//        val aboutIcon = rootview.findViewById<ImageView>(R.id.about_image)
//        aboutIcon.drawable.setColorFilter(Color.parseColor("#C0C0C0"), PorterDuff.Mode.MULTIPLY)
//


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
