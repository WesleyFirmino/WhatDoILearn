package com.devventurus.whatdoilearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devventurus.whatdoilearn.databinding.ActivityMainBinding
import com.devventurus.whatdoilearn.view.LearnedItemAdapter
import com.devventurus.whatdoilearn.data.LearnedItemDataBase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        val learnedItems = LearnedItemDataBase.getAll()

        adapter.learnedItems = learnedItems
        recycler.adapter = adapter
    }
}