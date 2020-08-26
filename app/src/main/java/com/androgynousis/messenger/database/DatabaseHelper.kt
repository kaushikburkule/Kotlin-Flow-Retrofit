package com.androgynousis.messenger.database

import com.androgynousis.messenger.entity.User
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>):Flow<Unit>

}