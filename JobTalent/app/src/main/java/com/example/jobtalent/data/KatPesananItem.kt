package com.example.jobtalent.data

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.KategoriPemangkas
import com.example.jobtalent.presentation.model.KategoriPenjahit
import com.example.jobtalent.presentation.model.KategoriServis

object KatPesananItem {
    val dataPenjahit = listOf(
        KategoriPenjahit(
            id = 1,
            name = "Anto Ramadhan",
            talent = "Penjahit",
            photo = R.drawable.anto
        ),
        KategoriPenjahit(
            id = 2,
            name = "Jajang Sutarman",
            talent = "Penjahit",
            photo = R.drawable.jajang
        ),
        KategoriPenjahit(
            id = 3,
            name = "Agus Gunawan",
            talent = "Penjahit",
            photo = R.drawable.agus
        ),
    )

    val dataPemangkas = listOf(
        KategoriPemangkas(
            id = 1,
            name = "Asep Sutisna",
            talent = "Pemangkas Rambut",
            photo = R.drawable.asep_sutisna
        ),
    )

    val dataServis = listOf(
        KategoriServis(
            id = 1,
            name = "Joko Abdillah",
            talent = "Service Elektronik",
            photo = R.drawable.joko
        ),
    )
}