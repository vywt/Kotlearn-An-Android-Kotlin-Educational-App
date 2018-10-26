package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Intro4TypeConversion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro4_type_conversion)

        val wb = findViewById<WebView>(R.id.wbIntro4)
        wb!!.loadUrl("file:///android_asset/intro4.html");
    }
}
