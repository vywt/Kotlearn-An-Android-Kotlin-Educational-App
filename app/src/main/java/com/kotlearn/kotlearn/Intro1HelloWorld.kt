package com.kotlearn.kotlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.webkit.WebView

class Intro1HelloWorld : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro1_hello_world)

        val wb = findViewById<WebView>(R.id.wbIntro1)
        wb!!.loadUrl("file:///android_asset/intro1.html");

    }
}
