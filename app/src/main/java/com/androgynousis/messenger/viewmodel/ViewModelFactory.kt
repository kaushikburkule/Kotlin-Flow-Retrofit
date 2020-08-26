package com.androgynousis.messenger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androgynousis.messenger.database.DatabaseHelper
import com.androgynousis.messenger.api.ApiHelper
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SplashViewModel::class.java))
            return SplashViewModel(apiHelper, dbHelper) as T
        throw IllegalArgumentException("Unknown Class Name")
    }

}