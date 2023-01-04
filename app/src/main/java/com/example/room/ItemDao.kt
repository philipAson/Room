package com.example.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {

    @Insert
    fun insert(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM item_table")
    fun getAll() : List<Item>

    @Query("SELECT * FROM item_table WHERE category LIKE :categoryName")
    fun findByCategory(categoryName: String) : List<Item>


}