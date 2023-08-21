package com.example.artcollecterapp

import android.content.Intent
import android.provider.MediaStore.Audio.Artists
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artcollecterapp.databinding.RecyclerRowBinding

class ArtAdapter(val artLists: ArrayList<Art>):RecyclerView.Adapter<ArtAdapter.ArtViewHolder>() {

    class ArtViewHolder(val binding :RecyclerRowBinding ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArtViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artLists.size
    }

    override fun onBindViewHolder(holder: ArtViewHolder, position: Int) {
        holder.binding.recyclerViewTextView.text = artLists[position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("info", "old")
            intent.putExtra("artId", artLists[position].id)
            holder.itemView.context.startActivity(intent)
        }
    }
}