package com.graymandev.sapp.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "records")
data class TimeRecord(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "date_time") val dateTime : String
)