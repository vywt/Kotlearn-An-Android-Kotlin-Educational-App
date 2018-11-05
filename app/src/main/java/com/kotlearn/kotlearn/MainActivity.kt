package com.kotlearn.kotlearn

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.kotlearn.kotlearn.LearnThroughTutorials.*
import com.kotlearn.kotlearn.LearnThroughVideos.LearnThroughVideoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var mAuth : FirebaseAuth;
//    val fragmentManager = supportFragmentManager
//    val transaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        var btn_goHome = findViewById<Button>(R.id.goHome)
//        btn_goHome.setOnClickListener {
//
////            val fragmentManager = cont
////            val transaction = fragmentManager!!.beginTransaction()
////
////            transaction.replace(R.id.fragmentUsed, IntroHomeFragment()).addToBackStack("Frag32").commit()
//
//        }

        mAuth = FirebaseAuth.getInstance()

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

//        var btn_goHome = findViewById<Button>(R.id.goHome)
//        btn_goHome.setOnClickListener {
//            transaction.replace(R.id.fragmentUsed, IntroHomeFragment()).commit()
//        }

        transaction.replace(R.id.fragmentUsed, IntroHomeFragment()).commit()


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentUsed, IntroHomeFragment()).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings ->
//                var myIntent = Intent(this, MainActivity::class.java)
//            startActivity(myIntent)
            return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.nav_intro1 -> {
                transaction.replace(R.id.fragmentUsed, Intro1HelloWorldFragment()).addToBackStack("Frag1").commit()
            }
            R.id.nav_intro2 -> {
                transaction.replace(R.id.fragmentUsed, Intro2VariablesBasicTypesFragment()).addToBackStack("Frag2").commit()
            }
            R.id.nav_intro3 -> {
                transaction.replace(R.id.fragmentUsed, Intro3OperatorsFragment()).addToBackStack("Frag3").commit()
            }
            R.id.nav_intro4 -> {
                transaction.replace(R.id.fragmentUsed, Intro4TypeConversionFragment()).addToBackStack("Frag4").commit()
            }
            R.id.nav_intro5 -> {
                transaction.replace(R.id.fragmentUsed, Intro5ExpressionFragment()).addToBackStack("Frag5").commit()
            }
            R.id.nav_intro6 -> {
                transaction.replace(R.id.fragmentUsed, Intro6BasicIOFragment()).addToBackStack("Frag6").commit()
            }

            R.id.nav_flowcontrol1 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl1IfFragment()).addToBackStack("Frag7").commit()
            }
            R.id.nav_flowcontrol2 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl2WhenFragment()).addToBackStack("Frag8").commit()
            }
            R.id.nav_flowcontrol3 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl3WhileFragment()).addToBackStack("Frag9").commit()
            }
            R.id.nav_flowcontrol4 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl4ForFragment()).addToBackStack("Frag10").commit()
            }
            R.id.nav_flowcontrol5 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl5BreakFragment()).addToBackStack("Frag11").commit()
            }
            R.id.nav_flowcontrol6 -> {
                transaction.replace(R.id.fragmentUsed, FlowControl6ContinueFragment()).addToBackStack("Frag12").commit()
            }
            R.id.nav_functions1 -> {
                transaction.replace(R.id.fragmentUsed, Functions1FunctionFragment()).addToBackStack("Frag13").commit()
            }
            R.id.nav_functions2 -> {
                transaction.replace(R.id.fragmentUsed, Functions2InfixFunctionCallFragment()).addToBackStack("Frag14").commit()
            }
            R.id.nav_functions3 -> {
                transaction.replace(R.id.fragmentUsed, Functions3DefaultNamedArgumentsFragment()).addToBackStack("Frag15").commit()
            }
            R.id.nav_functions4 -> {
                transaction.replace(R.id.fragmentUsed, Functions4RecursionFragment()).addToBackStack("Frag16").commit()
            }
            R.id.nav_oop1 -> {
                transaction.replace(R.id.fragmentUsed, OOP1ClassObjectsFragment()).addToBackStack("Frag17").commit()
            }
            R.id.nav_oop2 -> {
                transaction.replace(R.id.fragmentUsed, OOP2ConstructorsFragment()).addToBackStack("Frag18").commit()
            }
            R.id.nav_oop3 -> {
                transaction.replace(R.id.fragmentUsed, OOP3GettersSettersFragment()).addToBackStack("Frag19").commit()
            }
            R.id.nav_oop4 -> {
                transaction.replace(R.id.fragmentUsed, OOP4InheritanceFragment()).addToBackStack("Frag20").commit()
            }
            R.id.nav_oop5 -> {
                transaction.replace(R.id.fragmentUsed, OOP5VisibilityModifiersFragment()).addToBackStack("Frag21").commit()
            }
            R.id.nav_oop6 -> {
                transaction.replace(R.id.fragmentUsed, OOP6AbstractClassFragment()).addToBackStack("Frag22").commit()
            }
            R.id.nav_oop7 -> {
                transaction.replace(R.id.fragmentUsed, OOP7InterfacesFragment()).addToBackStack("Frag23").commit()
            }
            R.id.nav_oop8 -> {
                transaction.replace(R.id.fragmentUsed, OOP8NestedInnerClassesFragment()).addToBackStack("Frag24").commit()
            }
            R.id.nav_oop9 -> {
                transaction.replace(R.id.fragmentUsed, OOP9DataClassFragment()).addToBackStack("Frag25").commit()
            }
            R.id.nav_oop10 -> {
                transaction.replace(R.id.fragmentUsed, OOP10SealedClassFragment()).addToBackStack("Frag26").commit()
            }
            R.id.nav_oop11 -> {
                transaction.replace(R.id.fragmentUsed, OOP11ObjectFragment()).addToBackStack("Frag27").commit()
            }
            R.id.nav_oop12 -> {
                transaction.replace(R.id.fragmentUsed, OOP12CompanionObjectsFragment()).addToBackStack("Frag28").commit()
            }
            R.id.nav_oop13 -> {
                transaction.replace(R.id.fragmentUsed, OOP13ExtensionFunctionFragment()).addToBackStack("Frag29").commit()
            }
            R.id.nav_oop14 -> {
                transaction.replace(R.id.fragmentUsed, OOP14OperatorOverloadingFragment()).addToBackStack("Frag30").commit()
            }
            R.id.nav_quiz -> {
                transaction.replace(R.id.fragmentUsed, QuizFragment()).addToBackStack("Frag31").commit()
            }

            R.id.nav_video -> {
                transaction.replace(R.id.fragmentUsed, LearnThroughVideoFragment()).addToBackStack("Frag32").commit()
            }

            R.id.chatroom -> {
                var myintent = Intent(this, ChatroomActivity::class.java)
                startActivity(myintent)
            }

            R.id.about -> {
                transaction.replace(R.id.fragmentUsed, CreditsFragment()).addToBackStack("Frag32").commit()
            }

            R.id.nav_editor -> {
                transaction.replace(R.id.fragmentUsed, EditorFragment()).addToBackStack("Frag33").commit()
            }

            R.id.logout -> {
                mAuth.signOut()
//                finish()
                var myIntent = Intent (this, LoginActivity::class.java)
                startActivity(myIntent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}