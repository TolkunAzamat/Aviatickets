package com.example.aviatickets.database.entities.appDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.aviatickets.database.entities.Dao.Dao
import com.example.aviatickets.database.entities.entities.*
import java.util.*

@Database(entities = [User::class,Admin::class,Flights::class], version =2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun Dao(): Dao
}

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
