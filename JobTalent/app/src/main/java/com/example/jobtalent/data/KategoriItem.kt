package com.example.jobtalent.data

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.KategoriKerja

object KategoriItem {
    val dataKategori = listOf(
        KategoriKerja(
            id = 1,
            name = "Musisi",
            tersedia = "Tersedia 30 Jasa",
            photo = R.drawable.musisi
        ),
        KategoriKerja(
            id = 2,
            name = "Desain",
            tersedia = "Tersedia 25 Jasa",
            photo = R.drawable.desain
        ),
        KategoriKerja(
            id = 3,
            name = "Event",
            tersedia = "Tersedia 15 Jasa",
            photo = R.drawable.event
        ),
        KategoriKerja(
            id = 4,
            name = "UMKM",
            tersedia = "Tersedia 145 Jasa",
            photo = R.drawable.umkm
        ),
    )
}

