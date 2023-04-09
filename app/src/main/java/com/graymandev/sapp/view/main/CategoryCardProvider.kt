package com.graymandev.sapp.view.main

import com.graymandev.sapp.R
import com.graymandev.sapp.model.CategoryCard

class CategoryCardProvider {
    companion object{
        val categoryCardList = listOf<CategoryCard>(
            CategoryCard(
                1, "Medicinal", R.drawable.image_medicinal
            ),
            CategoryCard(
                2, "Tools", R.drawable.image_garden_tools
            ),
            CategoryCard(
                3, "Courses", R.drawable.image_garden_courses
            ),
            CategoryCard(
                4, "Aromas", R.drawable.image_aromas
            ),
            CategoryCard(
                5, "Consumables", R.drawable.image_consumables
            ),
            CategoryCard(
                6, "Fashion", R.drawable.image_fashion
            ),
            CategoryCard(
                7, "Bakery", R.drawable.image_bakery
            ),
            CategoryCard(
                8, "Branding", R.drawable.image_branding
            )
        )
    }
}