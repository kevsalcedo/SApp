package com.graymandev.sapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Store(
    val id: Int,
    val name: String,
    val image: Int,
    val score: Double,
    val price: Int,
    val deliveryTime: Int,
    val latitude: Double,
    val longitude: Double
    //TODO: add the val tags: MutableList<String>
) : Parcelable