package com.androgynousis.messenger.view.activities

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.androgynousis.messenger.R
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class BaseActivity : AppCompatActivity() {

    @JvmField
    var toolbar: Toolbar? = null
    var title: TextView? = null
    fun changeTitle(toolbarId: Int, titlePage: String?) {
        toolbar = findViewById<View>(toolbarId) as Toolbar
        setSupportActionBar(toolbar)
        title = toolbar!!.findViewById<View>(R.id.tv_title) as TextView
        title!!.text = titlePage
        supportActionBar!!.title = ""
    }

    fun setupToolbar(toolbarId: Int, titlePage: String?) {
        toolbar = findViewById<View>(toolbarId) as Toolbar
        setSupportActionBar(toolbar)
        title = toolbar!!.findViewById<View>(R.id.tv_title) as TextView
        title!!.text = titlePage
        supportActionBar!!.title = ""
    }

    fun setupToolbarWithUpNav(toolbarId: Int, titlePage: String?, @DrawableRes res: Int) {
        toolbar = findViewById<View>(toolbarId) as Toolbar
        setSupportActionBar(toolbar)
        title = toolbar!!.findViewById<View>(R.id.tv_title) as TextView
        title!!.text = titlePage
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(res)
        supportActionBar!!.title = ""
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

}