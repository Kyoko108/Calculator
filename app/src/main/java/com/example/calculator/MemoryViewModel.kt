package com.example.calculator

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calculator.data.Memory
import com.example.calculator.data.MemoryDao
import com.example.calculator.data.MemoryDatabase
import kotlinx.coroutines.launch

class MemoryViewModel : ViewModel() {
    lateinit var memory0List:LiveData<List<Memory>>
     lateinit var memoryDao: MemoryDao


     fun init (app:Application){
        memoryDao = MemoryDatabase.getDatabase(app).getDao()
        memory0List = memoryDao.getAllMemory()

    }

  fun saveMemory(data:String)
    {
       viewModelScope.launch {
           memoryDao.saveMemory(Memory(memory = data)) }

    }
}