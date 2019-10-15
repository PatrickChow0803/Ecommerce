package com.patrickchow.patsecommerce.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Query("Select * From ProductFromDatabase")
    fun getAll(): List<ProductFromDatabase>

    @Insert
    fun insertAll(vararg products: ProductFromDatabase)

}