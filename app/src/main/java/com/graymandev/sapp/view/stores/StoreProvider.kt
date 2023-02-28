package com.graymandev.sapp.view.stores

import com.graymandev.sapp.R
import com.graymandev.sapp.model.Store

class StoreProvider {
    companion object{
        val storeList = listOf<Store>(
            // TODO: update store images, delivery time and solve how to add the tag list to each store.
            Store(
                1, "4Growers", R.drawable.ic_death_flower,4.80F, R.drawable.ic_money, 20,
                11.007940300000145, -74.82832618221654
            ),
            Store(
                2, "HempStore", R.drawable.logo_store,4.40F, R.drawable.ic_money, 20,
                11.006226277117571, -74.82933912722143
            ),
            Store(
                3, "MiramarStore", R.drawable.logo_store,4.70F, R.drawable.ic_money,20,
                11.00331935755897, -74.83527378717983
            ),
            Store(
                4, "BQLStore", R.drawable.ic_death_flower,4.20F, R.drawable.ic_money,20,
                11.009356607035349, -74.82432116553058
            ),
            Store(
                5, "MedicalGarden", R.drawable.logo_store,4.50F, R.drawable.ic_money,20,
                11.013714093413927, -74.8117907432746
            ),
            Store(
                6, "VuseStore", R.drawable.logo_store,3.90F, R.drawable.ic_money,20,
                10.984112821722972, -74.81193980509575
            ),
            Store(
                7, "SENA", R.drawable.ic_death_flower,4.30F, R.drawable.ic_money,20,
                10.980194792183447, -74.78532827141602
            ),
            Store(
                8, "HotCookies", R.drawable.logo_store,4.60F, R.drawable.ic_money,20,
                10.981429129633945, -74.83399462391807
            ),
            Store(
                9, "GardenFashion", R.drawable.logo_store,4.60F, R.drawable.ic_money,20,
                10.981429129633945, -74.83399462391807
            ),
            Store(
                10, "SmellsGood", R.drawable.ic_death_flower,4.10F, R.drawable.ic_money,20,
                11.010029593379562, -74.79579256630468
            )
        )

    }
}