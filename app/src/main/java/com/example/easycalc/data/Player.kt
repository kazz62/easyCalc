package com.example.easycalc.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")
data class Player(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)
