package com.example.calculator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoryDao {

    @Insert
    suspend fun saveMemory(mEmory:Memory,data:String)

    @Query ( "Select * FROM  Memory")
   suspend  fun getAllMemory():LiveData<List<Memory>>
}