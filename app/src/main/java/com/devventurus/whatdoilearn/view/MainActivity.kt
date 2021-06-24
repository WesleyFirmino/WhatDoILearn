package com.devventurus.whatdoilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.devventurus.whatdoilearn.databinding.ActivityMainBinding
import com.devventurus.whatdoilearn.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter


        val items = viewModel.learnedItems
        items.observe(this, Observer{
            adapter.learnedItems = it
        })

        binding.newItemButton.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }
    }
}