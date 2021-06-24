package com.devventurus.whatdoilearn.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devventurus.whatdoilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {

    @Query("SELECT * FROM learned_item ORDER BY item_name ASC")
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert
    fun insert(learnedItem: LearnedItem)

    @Insert
    fun insert(learnedItem: List<LearnedItem>)
}