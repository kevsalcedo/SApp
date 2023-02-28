package com.graymandev.sapp.view.stores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.graymandev.sapp.R
import com.graymandev.sapp.databinding.ItemStoreBinding
import com.graymandev.sapp.model.Store

class StoresListAdapter(
    private var storesList: List<Store>
) : RecyclerView.Adapter<StoresListAdapter.StoresItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoresItemViewHolder {
        return StoresListAdapter.StoresItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_store,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = storesList.size

    override fun onBindViewHolder(holder: StoresItemViewHolder, position: Int) {
        val model = storesList[position]
        holder.render(model)
    }

    class StoresItemViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ItemStoreBinding.bind(view)

        fun render(storeModel: Store){
            binding.textViewItemStoreName.text = storeModel.name
            binding.textViewItemStoreRate.text = storeModel.score.toString()
            binding.textViewDeliveryTime.text = storeModel.deliveryTime.toString()
            Glide.with(binding.imageViewItemStore.context).load(storeModel.image).into(binding.imageViewItemStore)
            Glide.with(binding.imageViewPrice.context).load(storeModel.price).into(binding.imageViewPrice)
            itemView.setOnClickListener {
                Toast.makeText(
                    binding.imageViewItemStore.context,
                    storeModel.name,
                    Toast.LENGTH_SHORT
                )
            }
        }
    }

}

