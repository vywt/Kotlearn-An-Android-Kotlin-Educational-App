package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Intro5Expression : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro5_expression)


        val wb = findViewById<WebView>(R.id.wbIntro5)
        wb!!.loadUrl("file:///android_asset/intro5.html");
    }
}
