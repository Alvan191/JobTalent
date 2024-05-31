package com.example.jobtalent.data

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.KategoriJasa

object KategoriJasaItem {
    val dataKategoriJasa = listOf(
        KategoriJasa(
            id = 1,
            name = "UMKM",
            photo = R.drawable.gambar_umkm
        ),
        KategoriJasa(
            id = 2,
            name = "Musisi",
            photo = R.drawable.gambar_musisi
        ),
        KategoriJasa(
            id = 3,
            name = "Desain",
            photo = R.drawable.gambar_desain
        ),
        KategoriJasa(
            id = 4,
            name = "Event",
            photo = R.drawable.gambar_event
        ),
    )
}


