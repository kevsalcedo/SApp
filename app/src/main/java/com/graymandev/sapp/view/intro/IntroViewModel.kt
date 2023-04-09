package com.graymandev.sapp.view.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.graymandev.sapp.model.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor() : ViewModel() {

    private val _navigateToSignUp = MutableLiveData<Event<Boolean>>()
    val navigateToSignUp: LiveData<Event<Boolean>>
        get() = _navigateToSignUp

    fun onSignUpSelected() {
        _navigateToSignUp.value = Event(true)
    }

}