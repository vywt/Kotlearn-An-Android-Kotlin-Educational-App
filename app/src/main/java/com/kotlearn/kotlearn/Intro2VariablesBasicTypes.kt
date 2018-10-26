package com.kotlearn.kotlearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener



class Intro2VariablesBasicTypes : AppCompatActivity() {

    var x1 : Float = 0.0f
    var x2 : Float = 0.0f
    var y1 : Float = 0.0f
    var y2 : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2_variables_basic_types)

        val wb = findViewById<WebView>(R.id.wbIntro2)
        wb!!.loadUrl("file:///android_asset/Intro2.html");
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        return super.onTouchEvent(event)

        if (event!!.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX()
            y1 = event.getY()
        } else if (event!!.getAction() == MotionEvent.ACTION_UP) {
            x2 = event.getX()
            y2 = event.getY()
            //swipe from right edge
            if (x1 > x2) {
                val myIntent = Intent(this, Intro3Operators::class.java)
                startActivity(myIntent)
            } else if (x1 < x2) {
                //swipe from left edge
                val myIntent = Intent(this, Intro1HelloWorld::class.java)
                startActivity(myIntent)
            }
        }
        return false
    }
}
