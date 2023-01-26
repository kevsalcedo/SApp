package com.graymandev.mvvmfoundation.view.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.mvvmfoundation.MainActivity
import com.graymandev.mvvmfoundation.databinding.ActivitySplashBinding

class SplashActivity : BindingActivity<ActivitySplashBinding>() {

    override fun setupViewBinding(inflater: LayoutInflater): ActivitySplashBinding{
        return ActivitySplashBinding.inflate(inflater)
    }

    override fun init() {
        Handler(Looper.getMainLooper()).postDelayed({
            // Start main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) //3000 is the timeout in milliseconds
    }
}