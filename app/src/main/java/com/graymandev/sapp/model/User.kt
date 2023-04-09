package com.graymandev.sapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String = "",
    val name: String = "",
    val surname: String = "",
    val nickname: String = "",
    val age: Int = 0,
    val orientation: String = "",
    val email: String = "",
    val mobile: Long = 0,
    val image: String = "",
): Parcelable