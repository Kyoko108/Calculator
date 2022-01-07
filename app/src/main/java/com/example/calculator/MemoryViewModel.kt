package com.example.calculator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MemoryViewModel (application: Application) :AndroidViewModel(application) {


    val allNotes : LiveData<List<Memory>>
    private val repository : MemoryRepository


    init {
        val dao = MemoryDatabase.getDatabase(application).getNotesDao()
        repository = MemoryRepository(dao)
        allNotes = repository.allNotes
    }




    fun addNote(note: Memory) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}