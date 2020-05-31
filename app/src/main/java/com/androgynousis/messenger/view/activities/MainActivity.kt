package com.androgynousis.messenger.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.androgynousis.messenger.R
import com.androgynousis.messenger.view.fragment.FragmentHome

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = FragmentHome()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.frameLayout, fragmentHome).commit()

    }

}