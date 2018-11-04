package com.kotlearn.kotlearn


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import kotlinx.android.synthetic.main.fragment_tutorial_frontpage.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TutorialFrontpageFragment : Fragment() {

    val header: MutableList<String> = ArrayList()
    val body: MutableList<MutableList<String>> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var rootView = inflater.inflate(R.layout.fragment_tutorial_frontpage, container, false)
        var expandableListView = rootView.findViewById<ExpandableListView>(R.id.expandableListView)

        var title = "Game Of Thrones"

        val introduction: MutableList<String> = ArrayList()
        introduction.add("Hello World")
        introduction.add("Operators")
        introduction.add("Type Conversion")
        introduction.add("Expression & Statement")
        introduction.add("Comments")
        introduction.add("Input and Output")
        
        val functions: MutableList<String> = ArrayList()
        functions.add("If Expression")
        functions.add("When Expression")
        functions.add("While Loop")
        functions.add("For Loop")
        functions.add("Break")
        functions.add("Continue")

        val flowcontrol: MutableList<String> = ArrayList()
        flowcontrol.add("Kotlin Function")
        flowcontrol.add("Infix Function Call")
        flowcontrol.add("Default and Named Arguments")
        flowcontrol.add("Recursion and Tail Recursion")
        
        val oop: MutableList<String> = ArrayList()
        oop.add("Class and Objects")
        oop.add("Kotlin Constructors")
        oop.add("Getters and Setters")
        oop.add("Inheritance")
        oop.add("Visibility Modifiers")
        oop.add("Abstract Class")
        oop.add("Interfaces")
        oop.add("Nested and Inner Classes")
        oop.add("Data Class")
        oop.add("Sealed Class")
        oop.add("Object")
        oop.add("Companion Objects")
        oop.add("Extension Function")

        header.add("1. Kotlin Introduction")
        header.add("2. Kotlin Flow Control")
        header.add("3. Kotlin Functions")
        header.add("4. Object Orientated Programming")

        body.add(introduction)
        body.add(functions)
        body.add(flowcontrol)
        body.add(oop)

//        var expandableListView = rootView.findViewById<ExpandableListAdapter>(R.id.expandableListView)

        expandableListView.setAdapter(ExpandableListAdapter(this@TutorialFrontpageFragment.context!!,expandableListView, header, body))

        return rootView
    }


}
