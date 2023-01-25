package com.graymandev.mvvmfoundation

import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.mvvmfoundation.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>() {
    private lateinit var navController: NavController
    private lateinit var thisMenu: Menu

    //This is called after onCreate, so binding is not null and can be safely used
    override fun init() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.navigationMenu.setupWithNavController(navController)
        thisMenu = binding.navigationMenu.menu
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
}