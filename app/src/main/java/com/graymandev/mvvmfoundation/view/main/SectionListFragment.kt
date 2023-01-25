package com.graymandev.mvvmfoundation.view.main


import android.view.LayoutInflater
import android.view.ViewGroup
import com.chetantuteja.easybinding.BindingFragment
import com.graymandev.mvvmfoundation.MainActivity
import com.graymandev.mvvmfoundation.databinding.FragmentSectionListBinding

class SectionListFragment : BindingFragment<FragmentSectionListBinding>() {
    override fun init() {
        binding.goToStoresBtn.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.navigateToStores()
        }
    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSectionListBinding {
       return FragmentSectionListBinding.inflate(inflater,container,false)
    }

}