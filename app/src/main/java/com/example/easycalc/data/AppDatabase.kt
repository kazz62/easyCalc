package com.example.easycalc.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Player::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PlayerDao(): PlayerDao
}