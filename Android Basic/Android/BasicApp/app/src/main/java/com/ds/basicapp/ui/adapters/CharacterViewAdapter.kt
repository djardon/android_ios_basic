package com.ds.basicapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ds.basicapp.app.extensions.loadAsyncImage
import com.ds.basicapp.databinding.FragmentItemCharacterBinding
import com.ds.basicapp.domain.models.Character
import com.ds.basicapp.domain.models.Characters

/**
 * [RecyclerView.Adapter] that can display a [Characters].
 */
class CharacterViewAdapter(
    private val values: Characters,
    private val onItemClickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<CharacterViewAdapter.ViewHolder>() {

    // Use Interface or Lambda
    interface OnItemClickListener {
        fun onItemClick(item: Character?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]

        holder.itemView.setOnClickListener { onItemClickListener?.onItemClick(item) }
        holder.image.loadAsyncImage(item.images.lg)
        holder.title.text = item.name
        holder.subtitle.text = item.biography.alignment.name
        holder.description.text = item.biography.publisher
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.itemImage
        val title: TextView = binding.itemTitle
        val subtitle: TextView = binding.itemSubtitle
        val description: TextView = binding.itemDescription
    }
}