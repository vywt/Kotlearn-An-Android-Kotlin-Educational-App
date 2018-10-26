package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Intro3Operators : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro3_operators)

        val wb = findViewById<WebView>(R.id.wbIntro3)
        wb!!.loadUrl("file:///android_asset/intro3.html");
    }
}
