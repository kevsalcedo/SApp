package com.graymandev.sapp.view.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.chetantuteja.easybinding.BindingFragment
import com.google.firebase.FirebaseApp
import com.graymandev.sapp.R
import com.graymandev.sapp.databinding.FragmentIntroBinding

class IntroFragment : BindingFragment<FragmentIntroBinding>() {

    private val introductionViewModel: IntroViewModel by viewModels()

    override fun init() {

        initUI()

    }

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentIntroBinding {
        return FragmentIntroBinding.inflate(inflater, container, false)
    }

    private fun initUI() {
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        with(binding) {
            //btnLogIn.setOnClickListener { introductionViewModel.onLoginSelected() }
            btnSignUp.setOnClickListener { introductionViewModel.onSignUpSelected() }
        }
    }

    private fun initObservers() {
        introductionViewModel.navigateToSignUp.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                goToSingUp()
            }
        })
    }

    private fun goToSingUp() {
        findNavController().navigate(R.id.action_introFragment_to_signUpFragment)
    }


}