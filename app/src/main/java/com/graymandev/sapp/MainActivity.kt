package com.graymandev.sapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.sapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.graymandev.sapp.view.login.LoginActivity
import com.graymandev.sapp.view.main.CarouselRVAdapter
import com.graymandev.sapp.view.navigation.IntentLauncher
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
        val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)

        binding.topAppBar.setupWithNavController(navController,appBarConfiguration)
        thisMenu = binding.navigationMenu.menu


        postToPromotionsList()

        binding.viewPagerCarousel.adapter = CarouselRVAdapter(promotionsList)

        val promotionsIndicator: CircleIndicator3 = findViewById<CircleIndicator3>(R.id.circle_indicator_carousel)
        promotionsIndicator.setViewPager(binding.viewPagerCarousel)

        binding.topAppBar.setOnMenuItemClickListener{ menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> {
                    IntentLauncher.goToLogin(this)
                    false
                }
                else -> {
                    false
                }
            }
        }

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

    private fun autoSliderCarousel(){
        //TODO create the auto slider (5seg)
    }



}