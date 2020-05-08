package com.androgynousis.messenger.view.activities

import android.content.Intent
import android.os.Bundle
import com.androgynousis.messenger.R
import kotlinx.android.synthetic.main.activity_setup_phone_number.*

class PhoneNumberActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setup_phone_number)
        //setupToolbar(R.id.tv_title, "Messenger")
        bt_continue.setOnClickListener { startActivity(Intent(this@PhoneNumberActivity, MainActivity::class.java)) }
    }
}