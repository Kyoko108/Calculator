package com.example.calculator

import androidx.lifecycle.LiveData

class MemoryRepository(private val notesDao: MemoryDao) {


    val allNotes: LiveData<List<Memory>> = notesDao.getAllNotes()


    suspend fun insert(note: Memory) {
        notesDao.insert(note)
    }


}