package com.androgynousis.messenger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androgynousis.messenger.database.DatabaseHelper
import com.androgynousis.messenger.api.ApiHelper
import com.androgynousis.messenger.model.ApiUser
import com.androgynousis.messenger.utils.Resource
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SplashViewModel(private val apiHelper: ApiHelper, dbHandler: DatabaseHelper) : ViewModel() {

    fun sample() = "Inject"

    private val users = MutableLiveData<Resource<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            apiHelper.getUsers()
                    .catch { e ->
                        users.postValue(Resource.error(e.toString(), null))
                    }
                    .collect {
                        users.postValue(Resource.success(it))
                    }
        }
    }

    fun getUsers(): LiveData<Resource<List<ApiUser>>> {
        return users
    }

}