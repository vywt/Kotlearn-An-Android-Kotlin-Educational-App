package com.kotlearn.kotlearn


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Intro1HelloWorldFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_intro1_hello_world, container, false)
        val wb = rootview.findViewById<WebView>(R.id.wbIntro1)
        wb.loadUrl("file:///android_asset/intro1.html");

        return rootview
    }


}
