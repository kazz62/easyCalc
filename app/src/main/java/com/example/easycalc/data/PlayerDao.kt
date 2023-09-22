package com.example.easycalc.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(data: Player)

    @Query("SELECT * FROM player_table")
    fun getAllPlayer(): List<Player>
}