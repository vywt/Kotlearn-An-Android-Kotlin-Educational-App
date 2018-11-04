package com.kotlearn.kotlearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.widget.Button
import android.widget.LinearLayout
import com.kotlearn.kotlearn.LearnThroughTutorials.Functions2InfixFunctionCallFragment
import com.kotlearn.kotlearn.R.id.viewpager
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    var images: IntArray = intArrayOf(R.drawable.icon1,
            R.drawable.icon2,
            R.drawable.icon3,
            R.drawable.icon4,
            R.drawable.icon5)
    var titles: Array<String?> = arrayOf("Welcome to KotLearn",
            "Learn kotlin!",
            "Test your understanding",
            "Watch from the best",
            "Example Solutions")
    var descriptions: Array<String?> = arrayOf("Kotlearn is an application that lets you learn kotlin easily and effectively",
            "Using tutorials, you can learn all about how to use Kotlin",
            "Test your knowledge of Kotlin by attempting the quiz, with full fledged explanations to deepen your understanding!",
            "Watch video tutorials on how to do Kotlin",
            "Plenty of example codes that show you how to use Kotlin in a variety of situations")
    var adapter :PagerAdapter = SliderAdapter(this, images, titles, descriptions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        viewpager.adapter = adapter
//        val fragmentManager = getFragmentManager()
//        val transaction = fragmentManager!!.beginTransaction()

//        viewpager.addOnPageChangeListener(viewListener)
//    }
//
//    var viewListener : ViewPager.OnPageChangeListener = ViewPager.OnPageChangeListener {
//


    }
}
