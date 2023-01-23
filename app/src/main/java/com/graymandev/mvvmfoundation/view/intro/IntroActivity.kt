package com.graymandev.mvvmfoundation.view.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.mvvmfoundation.databinding.ActivityIntroBinding
import com.graymandev.mvvmfoundation.databinding.ActivitySplashBinding

class IntroActivity : BindingActivity<ActivityIntroBinding>() {

    override fun setupViewBinding(inflater: LayoutInflater): ActivityIntroBinding{
        return ActivityIntroBinding.inflate(inflater)
    }

    override fun init() {

    }

}