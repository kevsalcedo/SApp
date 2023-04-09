package com.graymandev.sapp.view.intro

import android.view.LayoutInflater
import android.view.Menu
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.chetantuteja.easybinding.BindingActivity
import com.google.firebase.FirebaseApp
import com.graymandev.sapp.R
import com.graymandev.sapp.databinding.ActivityIntroBinding

class IntroActivity : BindingActivity<ActivityIntroBinding>() {

    private lateinit var navController: NavController
    private lateinit var thisMenu: Menu

    override fun init() {
        val navIntroFragment = supportFragmentManager.findFragmentById(R.id.intro_fragment) as NavHostFragment
        navController = navIntroFragment.navController
    }

    override fun setupViewBinding(inflater: LayoutInflater): ActivityIntroBinding{
        return ActivityIntroBinding.inflate(inflater)
    }

}