package com.example.calculator.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memory( @PrimaryKey(autoGenerate = true) val id:Int=0 ,val memory:String)
