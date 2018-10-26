package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Intro6BasicIO : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro6_basic_io)

        val wb = findViewById<WebView>(R.id.wbIntro6)
        wb!!.loadUrl("file:///android_asset/intro6.html");
    }
}
