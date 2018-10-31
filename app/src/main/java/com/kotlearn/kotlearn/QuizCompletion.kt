package com.kotlearn.kotlearn

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class QuizCompletion : AppCompatActivity() {

    lateinit var btnFb : ImageButton
    lateinit var uriString : String
    var hasPackage: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_completion)

        btnFb = findViewById(R.id.fbButton)
        //check if the fb app is installed or not by calling this function -> method 1

        var score : Int = intent.getIntExtra("Score", -1)

        val scorePct = findViewById<TextView>(R.id.tv_percentage)
        val actualScore = findViewById<TextView>(R.id.tv_score)

        var pctToDisplay : Int = score/22
        scorePct.setText(pctToDisplay.toString() + "%")
        actualScore.setText(score.toString() + " out of 22")

        hasPackage = checkFacebookPackage(this@QuizCompletion, "com.facebook.katana")

        btnFb.setOnClickListener{

            if (hasPackage) {
                Toast.makeText(applicationContext, "Facebook is installed", Toast.LENGTH_LONG).show()

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"

                uriString = "I scored ?? % on my Kotlin quiz. Use Kotlearn to start learning too!" + "www.google.com"

                intent.putExtra(Intent.EXTRA_TEXT, uriString)
                intent.`package` = "com.facebook.katana"

                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "FB Not installed", Toast.LENGTH_LONG).show()
            }


        }


    }

    private fun checkFacebookPackage(context: Context, target: String): Boolean {
        val pm = context.packageManager
        try {
            pm.getPackageInfo(target, PackageManager.GET_META_DATA)
        } catch (exp: PackageManager.NameNotFoundException) {
            return false
        }
        return true
    }
}
