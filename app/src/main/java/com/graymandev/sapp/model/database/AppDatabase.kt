package com.graymandev.sapp.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.graymandev.sapp.model.database.entities.TimeRecord

@Database(entities = [TimeRecord::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun timeRecordsDao() : TimeRecordsDao
}