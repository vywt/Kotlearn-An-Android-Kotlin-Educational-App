package com.kotlearn.kotlearn.LearnThroughTutorials


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button

import com.kotlearn.kotlearn.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class OOP5VisibilityModifiersFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_oop5_visibility_modifiers, container, false)
        val wb = rootView.findViewById<WebView>(R.id.wbOOP5)
        wb.loadUrl("file:///android_asset/oop5.html")

        val fragmentManager = getFragmentManager()
        val transaction = fragmentManager!!.beginTransaction()

        var btn_previous = rootView.findViewById<Button>(R.id.btn_oop5_previous)
        var btn_next = rootView.findViewById<Button>(R.id.btn_oop5_next)

        btn_next.setOnClickListener{
            transaction.replace(R.id.fragmentUsed, OOP6AbstractClassFragment()).commit()
        }

        btn_previous.setOnClickListener{
            transaction.replace(R.id.fragmentUsed, OOP4InheritanceFragment()).commit()
        }

        return rootView
    }


}
