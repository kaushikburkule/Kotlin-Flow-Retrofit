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
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.androgynousis.messenger.R
import com.androgynousis.messenger.view.fragment.FragmentContacts
import com.androgynousis.messenger.view.fragment.FragmentHome
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var chats: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = FragmentHome()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameLayout, fragmentHome).commit()

        //val toggle = ActionBarDrawerToggle(this, drawer_layout, tool, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        //drawer_layout!!.setDrawerListener(toggle)
        //toggle.syncState()

        nav_view!!.setNavigationItemSelectedListener(this)
        nav_view_bottom!!.setNavigationItemSelectedListener(this)
        initializeCountDrawer()
    }

    private fun initializeCountDrawer() {
        chats = MenuItemCompat.getActionView(nav_view!!.menu.findItem(R.id.nav_chats)) as TextView
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
        if (drawer.isDrawerOpen(GravityCompat.START)) drawer.closeDrawer(GravityCompat.START) else super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawer_layout!!.openDrawer(GravityCompat.START)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val ft: FragmentTransaction
        when (item.itemId) {
            R.id.nav_contacts -> {
                val fragmentContacts = FragmentContacts()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frameLayout, fragmentContacts).addToBackStack(null).commit()
            }
            R.id.nav_chats -> {
                val fragmentHome = FragmentHome()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.frameLayout, fragmentHome).commit()
            }
            R.id.nav_trash -> {
            }
            R.id.nav_settings -> {
            }
            R.id.nav_logout -> {
            }
        }
        drawer_layout!!.closeDrawer(GravityCompat.START)
        return true
    }

}