package com.devventurus.whatdoilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devventurus.whatdoilearn.databinding.ActivityNewItemBinding

class NewItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewItemBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.title = "New Learned Item"

        binding.saveButton.setOnClickListener{
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}