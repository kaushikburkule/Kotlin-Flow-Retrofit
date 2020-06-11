package com.androgynousis.messenger.view.activities

import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.androgynousis.messenger.R
import com.androgynousis.messenger.view.fragment.FragmentContacts
import com.androgynousis.messenger.view.fragment.FragmentHome
import com.google.android.material.navigation.NavigationView

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    var chats: TextView? = null
    var navigationView: NavigationView? = null
    var navigationViewBottom: NavigationView? = null
    var drawer: DrawerLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar, "Messages")
        val ft: FragmentTransaction
        val fragmentHome = FragmentHome()
        ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameLayout, fragmentHome).commit()
        drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer!!.setDrawerListener(toggle)
        toggle.syncState()
        navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView!!.setNavigationItemSelectedListener(this)
        navigationViewBottom = findViewById<View>(R.id.nav_view_bottom) as NavigationView
        navigationViewBottom!!.setNavigationItemSelectedListener(this)
        chats = MenuItemCompat.getActionView(navigationView!!.menu.findItem(R.id.nav_chats)) as TextView
        initializeCountDrawer()
    }

    private fun initializeCountDrawer() {
        chats!!.gravity = Gravity.CENTER
        chats!!.setTypeface(null, Typeface.BOLD)
        chats!!.setTextColor(resources.getColor(R.color.colorAccent))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            chats!!.setTextAppearance(R.style.LightNav)
            chats!!.setTextColor(resources.getColor(R.color.colorAccent))
        }
        chats!!.text = "99+"
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawer!!.openDrawer(GravityCompat.START) // OPEN DRAWER
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean { // Handle navigation view item clicks here.
        val ft: FragmentTransaction
        val id = item.itemId
        if (id == R.id.nav_contacts) {
            val fragmentContacts = FragmentContacts()
            ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frameLayout, fragmentContacts).addToBackStack(null).commit()
        } else if (id == R.id.nav_chats) {
            val fragmentHome = FragmentHome()
            ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.frameLayout, fragmentHome).commit()
        } else if (id == R.id.nav_trash) {
        } else if (id == R.id.nav_settings) {
        } else if (id == R.id.nav_logout) {
        }
        drawer!!.closeDrawer(GravityCompat.START)
        return true
    }

}