package com.example.bookmania.activity


import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat
import com.example.bookmania.*
import com.example.bookmania.fragment.AboutAppFragment
import com.example.bookmania.fragment.DashboardFragment
import com.example.bookmania.fragment.FavouritesFragment
import com.example.bookmania.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
   // prevoiusly checked menu item
    var previousMenuItem:MenuItem? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()
        //toolbar - anywhere , actionbar - top of screen

        //open dashboard as initial activity
        //supportFragmentManager.beginTransaction()
        //  .replace(R.id.frame , DashboardFragment())
        //.addToBackStack("Dashboard")
        //.commit()
        // supportActionBar?.title = "Dashboard"
        // replace code with dashboard method to make code clear
        openDashboard()

        //which act toggle placed
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,  // navigation drawer
            R.string.open_drawer, // action string : act 11
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle) // click listener on hamburger
        actionBarDrawerToggle.syncState()
        // change hamburger icon to back icon and vice versa

        navigationView.setNavigationItemSelectedListener {

            if(previousMenuItem!=null){  //if some menu item is checked previously
               previousMenuItem?.isChecked = false //unchecked
           }
           it.isCheckable = true //check current menu item
            it.isChecked = true
            previousMenuItem = it //make current to prev

            //using it get currently selected item
            when (it.itemId) {
                R.id.dashboard -> {
                    //open when dashboard is tapped
                    supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.frame,
                            DashboardFragment()
                        ) //dashboard fragment replacing blank frame
                       // .addToBackStack("Dashboard")  //add fragment to backstack to ostire transactions
                        .commit()
                    supportActionBar?.title = "Dashboard" //chnge toolbar title with fragment
                    //close drawer when transaction commited
                    drawerLayout.closeDrawers()
                }

                R.id.favourites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FavouritesFragment())
                        .commit()
                    supportActionBar?.title = "Favourites"
                    drawerLayout.closeDrawers()
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ProfileFragment())
                        .commit()
                    supportActionBar?.title = "Profile"
                    drawerLayout.closeDrawers()
                }

                R.id.aboutApp -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutAppFragment())
                        .commit()
                    supportActionBar?.title = "About App"
                    drawerLayout.closeDrawers()
                }

            }
            return@setNavigationItemSelectedListener true
        }

    }

    fun setUpToolbar() {
        setSupportActionBar(toolbar)
        //null coz sometimes we wont have toolbar on screen
        supportActionBar?.title = "Toolbar Title"
        //for home button -> later change it to hamburger
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // only btn define not working


    }

    //click listener on action bar to make it working
    //menuitem -  home button
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) { //hamburger id
            drawerLayout.openDrawer(GravityCompat.START) // drawer open from left
        }

        return super.onOptionsItemSelected(item)
    }
//opening dashboard
    fun openDashboard() {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
    //checked : when app initially open
       navigationView.setCheckedItem(R.id.dashboard)
        
    }

    override fun onBackPressed(){
        //holds fragment currently displayed
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

       //frame not dashboard then open dashboard
        when(frag){
           !is DashboardFragment -> openDashboard()

            else -> super.onBackPressed()
        }
    }
}