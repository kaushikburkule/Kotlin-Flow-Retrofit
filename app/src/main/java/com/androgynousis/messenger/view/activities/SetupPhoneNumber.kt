package com.androgynousis.messenger.view.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.androgynousis.messenger.R

class SetupPhoneNumber : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_phone_number)
        setupToolbar(R.id.toolbar, "Setting Messenger")
        val button = findViewById<View>(R.id.bt_continue) as Button
        button.setOnClickListener { startActivity(Intent(this@SetupPhoneNumber, MainActivity::class.java)) }
    }
}