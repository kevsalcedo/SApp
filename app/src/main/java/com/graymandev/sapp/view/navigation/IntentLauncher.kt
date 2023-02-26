package com.graymandev.sapp.view.navigation

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.graymandev.sapp.view.login.LoginActivity

object IntentLauncher {
    fun goToLogin(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(context,intent,null)
    }
}