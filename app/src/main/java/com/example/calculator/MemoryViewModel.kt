package com.example.calculator

import android.app.Application
import androidx.lifecycle.LiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.data.Memory
import com.example.calculator.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.calculator.data.MemoryDao
import com.example.calculator.data.MemoryDatabase
import kotlinx.coroutines.launch

class MemoryViewModel:ViewModel() {
    private lateinit var memoryDao: MemoryDao
    lateinit var memoryList:LiveData<List<MemoryDao>>

    suspend fun init (app:Application){
        memoryDao = MemoryDatabase.getDatabase(app).getDao()
        memoryList = memoryDao.getAllMemory()
    }

  fun saveMemory(data:String)
    {
       viewModelScope.launch {
           memoryDao.saveMemory(Memory(memory = data)) }

    }
}