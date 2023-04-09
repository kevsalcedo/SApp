package com.graymandev.sapp.splash

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.chetantuteja.easybinding.BindingActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.graymandev.sapp.MainActivity
import com.graymandev.sapp.databinding.ActivitySplashBinding
import com.graymandev.sapp.view.intro.IntroActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>() {
    override fun init() {

        FirebaseApp.initializeApp(this)

        Handler(Looper.getMainLooper()).postDelayed({
            //checkUserStatusAndRedirect()
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
        }, 3000) //3000 is the timeout in milliseconds
    }

    override fun setupViewBinding(inflater: LayoutInflater): ActivitySplashBinding{
        return ActivitySplashBinding.inflate(inflater)
    }

    /**
     * A function to check the status of the user and send it to MainActivity or IntroActivity.
     */
    private fun checkUserStatusAndRedirect(){
        // If the user is signed in once and not signed out again from the app. So next time while coming into the app
        // we will redirect him to MainScreen or else to the Intro Screen as it was before.

        // Get the current user id
        val currentUserID = getCurrentUserID()

        if (currentUserID.isNotEmpty()) {
            // Start the Main Activity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        } else {
            // Start the Intro Activity
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
        }

        // Call this when your activity is done and should be closed.
        finish()
    }

    /**
     * A function for getting the user id of current logged user.
     */
    private fun getCurrentUserID(): String {

        // An Instance of currentUser using FirebaseAuth
        val currentUser = FirebaseAuth.getInstance().currentUser

        // A variable to assign the currentUserId if it is not null or else it will be blank.
        var currentUserID = ""
        if (currentUser != null) {
            currentUserID = currentUser.uid
        }
        return currentUserID
    }



}