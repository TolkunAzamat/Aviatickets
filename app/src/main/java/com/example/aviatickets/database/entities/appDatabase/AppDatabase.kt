package com.example.aviatickets.database.entities.appDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aviatickets.database.entities.Dao.Dao
import com.example.aviatickets.database.entities.entities.User

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun Dao(): Dao
}