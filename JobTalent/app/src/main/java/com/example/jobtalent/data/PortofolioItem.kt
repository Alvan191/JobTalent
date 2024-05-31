package com.example.jobtalent.data

import android.provider.ContactsContract.Contacts.Photo
import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.DesainPortofolio

object PortofolioItem {
    val dataPortofolio = listOf(
        DesainPortofolio(
            id = 1,
            name = "Desain - Baju blouse dengan berbagai model",
            photo = R.drawable.desain_satu
        ),
        DesainPortofolio(
            id = 2,
            name = "Desain - Jas, outer, kemeja formal ",
            photo = R.drawable.desain_dua
        ),
        DesainPortofolio(
            id = 3,
            name = "Desain - Kebaya modern untuk acara",
            photo = R.drawable.desain_tiga
        ),
        DesainPortofolio(
            id = 4,
            name = "Jahit - seragam kantoran batik",
            photo = R.drawable.desain_empat
        ),
    )
}

