package com.example.calculator

import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "memoryTable")

class Memory(@ColumnInfo(name = "title") val noteTitle:EditText, @ColumnInfo(name = "description") val noteDescription:String, @ColumnInfo(name = "timestamp") val timeStamp: TextView):
    Fragment() {

    @field:PrimaryKey(autoGenerate = true)
    private var id = 0


}