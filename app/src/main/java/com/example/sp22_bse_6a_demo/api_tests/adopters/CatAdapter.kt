package com.example.sp22_bse_6a_demo.api_tests.adopters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sp22_bse_6a_demo.R
import com.example.sp22_bse_6a_demo.api_tests.models.CatFactModel
import com.example.sp22_bse_6a_demo.databinding.CatRowBinding


class CatAdapter(catList: List<CatFactModel>) : RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    private val catList: List<CatFactModel> = catList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding: CatRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cat_row,
            parent,
            false
        )
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat: CatFactModel = catList[position]
        holder.binding.cat = cat
        holder.binding.executePendingBindings()

        // Load the image using Glide
        Glide.with(holder.binding.root.context)
            .load(cat.image) // Load the image URL
            .into(holder.binding.imageViewCat); // Set the image into ImageView
    }

    override fun getItemCount(): Int {
        return catList.size
    }

    class CatViewHolder(binding: CatRowBinding) : RecyclerView.ViewHolder(binding.getRoot()) {
        val binding: CatRowBinding = binding
    }
}
