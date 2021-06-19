package com.devventurus.whatdoilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devventurus.whatdoilearn.R
import com.devventurus.whatdoilearn.data.LearnedItem

class LearnedItemAdapter : RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {

    var learnedItems = listOf<LearnedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item, parent, false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItems[position]

        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnedItems.size
    }

    inner class LearnedItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleContainer : TextView = itemView.findViewById(R.id.learnedItemTitle)
        private val descriptionContainer : TextView = itemView.findViewById(R.id.learnedItemDescription)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description

        }

    }
}