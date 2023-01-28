package com.graymandev.mvvmfoundation

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.mvvmfoundation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.graymandev.mvvmfoundation.view.navigation.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator3

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>() {
    private lateinit var navController: NavController
    private lateinit var thisMenu: Menu

    private var promotionsList = mutableListOf<Int>()


    //This is called after onCreate, so binding is not null and can be safely used
    override fun init() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.navigationMenu.setupWithNavController(navController)
        thisMenu = binding.navigationMenu.menu

        postToPromotionsList()

        binding.viewPagerCarousel.adapter = CarouselRVAdapter(promotionsList)

        val promotionsIndicator: CircleIndicator3 = findViewById<CircleIndicator3>(R.id.circle_indicator_carousel)
        promotionsIndicator.setViewPager(binding.viewPagerCarousel)

    }

    fun navigateToStores() {
        val storesItem = thisMenu.findItem(R.id.storesListFragment)
        onOptionsItemSelected(storesItem)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    //This happens inside onCreate
    override fun setupViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    private fun addToPromotionsList(image: Int){
        promotionsList.add(image)
    }

    private fun postToPromotionsList(){
        addToPromotionsList(R.drawable.hierbabuena_leaves)
        addToPromotionsList(R.drawable.lavanda_flower)
        addToPromotionsList(R.drawable.lobelia_flower)
    }


}