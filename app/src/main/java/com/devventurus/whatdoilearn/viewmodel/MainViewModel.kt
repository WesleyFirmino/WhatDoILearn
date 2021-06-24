package com.devventurus.whatdoilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devventurus.whatdoilearn.data.LearnedItemRepository
import com.devventurus.whatdoilearn.entities.LearnedItem

class MainViewModel(
    private val repository: LearnedItemRepository
    ) : ViewModel() {
    val learnedItems: LiveData<List<LearnedItem>> = repository.learnedItem
}