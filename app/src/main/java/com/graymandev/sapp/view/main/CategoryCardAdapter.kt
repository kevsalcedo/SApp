package com.graymandev.sapp.view.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.graymandev.sapp.R
import com.graymandev.sapp.databinding.ItemCategoryCardBinding
import com.graymandev.sapp.model.CategoryCard

class CategoryCardAdapter(
    private val context: Context,
    private var categoryCardList: List<CategoryCard>
) : RecyclerView.Adapter<CategoryCardAdapter.CategoryCardItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryCardItemViewHolder {
        return CategoryCardItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_category_card,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = categoryCardList.size

    override fun onBindViewHolder(holder: CategoryCardItemViewHolder, position: Int) {
        val model = categoryCardList[position]
        holder.render(model)
    }

    class CategoryCardItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val binding = ItemCategoryCardBinding.bind(view)

        fun render(categoryCardModel: CategoryCard){
            binding.textViewCategoryCard.text = categoryCardModel.name
            Glide.with(binding.imageViewCategoryCard.context).load(categoryCardModel.image).into(binding.imageViewCategoryCard)
            itemView.setOnClickListener {
                Toast.makeText(
                    binding.imageViewCategoryCard.context,
                    categoryCardModel.name,
                    Toast.LENGTH_SHORT
                )
            }
        }
    }

}