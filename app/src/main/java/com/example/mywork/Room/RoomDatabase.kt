package com.example.mywork.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [Todo::class],
    version = 1
)
abstract class RoomDatabasee: RoomDatabase() {

    abstract fun dao(): Dao

    companion object{

        @Volatile
            private var INSTANCE: RoomDatabasee? = null

        fun getInstance(context: Context): RoomDatabasee {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabasee::class.java,
                    "room_data"
                ).build()
                INSTANCE = instance
                instance
            }
        }

    }
}