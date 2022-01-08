package com.example.calculator

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.data.MemoryDao
import com.example.calculator.data.MemoryDatabase
import kotlinx.coroutines.launch

class MemoryViewModel:ViewModel() {
    private lateinit var memoryDao: MemoryDao
    lateinit var memoryListLiveData:LiveData<List<MemoryDao>>

    fun init (app:Application){
        memoryDao = MemoryDatabase.getDatabase(app).getDao()
    }

  fun saveMemory(data:String)
    {
       viewModelScope.launch {
           memoryDao.saveMemory(data = data) }

    }
}