package com.androgynousis.messenger.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androgynousis.messenger.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}