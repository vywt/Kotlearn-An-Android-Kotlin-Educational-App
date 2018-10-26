package com.kotlearn.kotlearn

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MotionEvent
import android.webkit.WebView
import android.widget.Switch

class Intro1HelloWorld : AppCompatActivity()  {

    var x1 : Float = 0.0f
    var x2 : Float = 0.0f
    var y1 : Float = 0.0f
    var y2 : Float = 0.0f



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1_hello_world)

        val wb = findViewById<WebView>(R.id.wbIntro1)
        wb!!.loadUrl("file:///android_asset/intro1.html");

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
                val myIntent = Intent(this, Intro2VariablesBasicTypes::class.java)
                startActivity(myIntent)
            }
        }
        return false
    }
}
