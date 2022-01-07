package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface MemoryDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Memory)





    @Query("Select * from memoryTable order by id ASC")
    fun getAllNotes(): LiveData<List<Memory>>


}