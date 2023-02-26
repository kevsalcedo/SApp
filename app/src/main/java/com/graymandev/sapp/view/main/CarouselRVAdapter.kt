package com.graymandev.sapp.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.graymandev.sapp.R

class CarouselRVAdapter(private val promotions: List<Int>) :
    RecyclerView.Adapter<CarouselRVAdapter.CarouselItemViewHolder>() {

    class CarouselItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val itemPromotions: ImageView = itemView.findViewById(R.id.image_view_carousel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselItemViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.item_carousel, parent, false)
        return CarouselItemViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: CarouselItemViewHolder, position: Int) {
        holder.itemPromotions.setImageResource(promotions[position])
    }

    override fun getItemCount(): Int {
        return promotions.size
    }

}