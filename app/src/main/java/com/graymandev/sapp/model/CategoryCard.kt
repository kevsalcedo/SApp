package com.graymandev.sapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryCard(
    val id: Int,
    val name: String?,
    val image: Int?,
) : Parcelable
