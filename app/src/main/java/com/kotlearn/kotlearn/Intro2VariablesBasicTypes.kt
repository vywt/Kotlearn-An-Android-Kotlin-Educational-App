package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener



class Intro2VariablesBasicTypes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro2_variables_basic_types)

        val wb = findViewById<WebView>(R.id.wb1)
        wb!!.loadUrl("file:///android_asset/Intro2.html");


    }
}
