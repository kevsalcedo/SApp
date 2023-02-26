package com.graymandev.sapp.view.intro

import android.view.LayoutInflater
import com.chetantuteja.easybinding.BindingActivity
import com.graymandev.sapp.databinding.ActivityIntroBinding

class IntroActivity : BindingActivity<ActivityIntroBinding>() {

    override fun setupViewBinding(inflater: LayoutInflater): ActivityIntroBinding{
        return ActivityIntroBinding.inflate(inflater)
    }

    override fun init() {

    }

}