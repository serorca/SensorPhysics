package es.uva.sensorphysics.ui.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.app.NavUtils
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import es.uva.sensorphysics.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_tools -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_projects -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottom_nav_view.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
    //    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.navigation_tools -> {
//
//
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.navigation_projects -> {
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

