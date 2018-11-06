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
class EditorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_editor, container, false)
        val wb = rootView.findViewById<WebView>(R.id.wbEditor)
        wb.getSettings().setJavaScriptEnabled(true);
        wb.getSettings().setLoadWithOverviewMode(true);
        wb.getSettings().setUseWideViewPort(true);
        wb.getSettings().setDomStorageEnabled(true);
        wb.getSettings().setSupportZoom(true);
        wb.getSettings().setBuiltInZoomControls(true);
        wb.getSettings().setDisplayZoomControls(false);

        wb.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        wb.setScrollbarFadingEnabled(false);
        wb.loadUrl("https://rextester.com/l/kotlin_online_compiler");
        return rootView
    }


}
