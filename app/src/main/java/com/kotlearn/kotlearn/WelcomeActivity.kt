package com.kotlearn.kotlearn

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    var images: IntArray = intArrayOf(R.drawable.logosquaretransparentwhitelarger,
            R.drawable.icon2,
            R.drawable.icon3,
            R.drawable.icon4,
            R.drawable.icon5,
            R.drawable.icon1)
    var titles: Array<String?> = arrayOf("Welcome to KotLearn",
            "Learn kotlin!",
            "Test your understanding",
            "Watch from the best",
            "Practice on the go",
            "Discuss and Learn Togther!")
    var descriptions: Array<String?> = arrayOf("Kotlearn is an application that lets you learn kotlin easily and effectively\n\n" + ">>> Slide Right >>>",
            "Using tutorials, you can learn all about how to use Kotlin\n\n" +
                    " >>> Slide Right >>>",
            "Attempt Kotlin quizzes equipped with full fledged explanations!\n\n" +
                    " >>> Slide Right >>>",
            "Watch video tutorials on how to do Kotlin\n\n" +
                    " >>> Slide Right >>>",
            "Practice Kotlin using the online editor and compiler!\n\n" +
                    " >>> Slide Right >>>",
            "Interact and discuss with fellow learners to learn Kotlin together!")
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
