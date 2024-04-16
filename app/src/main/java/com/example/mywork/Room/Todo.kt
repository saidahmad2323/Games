package com.example.mywork.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "table_name")
data class Todo(
    @ColumnInfo val title: String,
    @ColumnInfo val subtitle: String,
    @ColumnInfo val createData: String = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date()),
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
