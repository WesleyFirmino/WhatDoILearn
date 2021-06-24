package com.devventurus.whatdoilearn.data

import androidx.lifecycle.LiveData
import com.devventurus.whatdoilearn.data.database.LearnedItemDao
import com.devventurus.whatdoilearn.entities.LearnedItem

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItem: LiveData<List<LearnedItem>> = dao.getAll()

    fun addNewItem(item: LearnedItem) {
        dao.insert(item)
    }
}