package com.example.calculator.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Memory :: class], version = 1)

abstract class MemoryDatabase:RoomDatabase() {

    abstract fun getDao():MemoryDao

    companion object{
        private var INSTANCE:MemoryDatabase?= null

        fun getDatabase (application :Application):MemoryDatabase
        {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    application,MemoryDatabase::class.java,"CalculatorMemory").build()
            }

            return INSTANCE !!
        }
    }
}