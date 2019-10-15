package com.patrickchow.patsecommerce.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductFromDatabase::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productDao() : ProductDao
}