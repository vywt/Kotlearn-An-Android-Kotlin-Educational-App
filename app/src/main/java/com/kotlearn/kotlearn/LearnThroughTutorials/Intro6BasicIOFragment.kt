package com.kotlearn.kotlearn.LearnThroughTutorials


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import com.kotlearn.kotlearn.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Intro6BasicIOFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_intro6_basic_io, container, false)
        val wb = rootview.findViewById<WebView>(R.id.wbIntro6)
        wb.loadUrl("file:///android_asset/intro6.html")

        return rootview
    }


}
