package com.kotlearn.kotlearn

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.PagerAdapter
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import org.w3c.dom.Text

class SliderAdapter : PagerAdapter {

    private var context: Context
    private var images: IntArray
    private var titles: Array<String?> = arrayOfNulls(5)
    private var descriptions: Array<String?> = arrayOfNulls(5)
    lateinit var inflater: LayoutInflater

    constructor(context: Context, images: IntArray, titles : Array<String?>, descriptions : Array<String?>) : super() {
        this.context = context
        this.images = images
        this.titles = titles
        this.descriptions = descriptions
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object` as RelativeLayout

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var image: ImageView
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = inflater.inflate(R.layout.slide_layout, container, false)
        image = view.findViewById(R.id.slide_layout_image)
        var tv_title = view.findViewById<TextView>(R.id.title)
        var tv_description = view.findViewById<TextView>(R.id.description)
        var btn_previous = view.findViewById<Button>(R.id.slide_layout_back)
        var btn_next = view.findViewById<Button>(R.id.slide_layout_next)
        tv_title.text = titles[position]
        tv_description.text = descriptions[position]

//        if (position == 0) {
//            btn_previous.visibility = Button.INVISIBLE
//        } else {
//            btn_previous.visibility = Button.VISIBLE
//        }

        if (position == 4) {
            btn_next.visibility = Button.VISIBLE
            btn_next.setOnClickListener {
                var myIntent = Intent(context, MainActivity::class.java)
                context.startActivity(myIntent)
            }
        }

        image.setImageResource(images[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(`object` as RelativeLayout)
    }
}