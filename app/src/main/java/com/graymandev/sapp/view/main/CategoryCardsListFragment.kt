package com.graymandev.sapp.view.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.sapp.MainActivity
import com.graymandev.sapp.databinding.FragmentCategoryCardsListBinding

class CategoryCardsListFragment : BindingFragment<FragmentCategoryCardsListBinding>() {
    override fun init() {
        binding.goToStoresBtn.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.navigateToStores()
        }

        binding.recyclerViewCategoryCards.layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerViewCategoryCards.adapter =
            activity?.let { CategoryCardAdapter(it, CategoryCardProvider.categoryCardList) }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategoryCardsListBinding {
       return FragmentCategoryCardsListBinding.inflate(inflater,container,false)
    }

}