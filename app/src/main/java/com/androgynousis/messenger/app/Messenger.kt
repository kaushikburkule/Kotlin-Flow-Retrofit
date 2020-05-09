package com.androgynousis.messenger.app

import android.app.Application

class Messenger : Application() {

    override fun isDeviceProtectedStorage(): Boolean {
        return super.isDeviceProtectedStorage()
    }

}