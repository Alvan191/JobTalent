package com.example.jobtalent.data.item

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.KategoriJasa

object KategoriJasaItem {
    val dataKategoriJasa = listOf(
        KategoriJasa(
            id = 1,
            name = "UMKM",
            photo = R.drawable.gambar_umkm,
            text_jasa_satu = "Penjahit",
            jasa_satu = R.drawable.gambar_jahit,
            text_jasa_dua = "Pemangkas Rambut",
            jasa_dua = R.drawable.gambar_pangkas,
            text_jasa_tiga = "Service Elektonik",
            jasa_tiga = R.drawable.gambar_electronik
        ),
        KategoriJasa(
            id = 2,
            name = "Musisi",
            photo = R.drawable.gambar_musisi,
            text_jasa_satu = "Gitaris",
            jasa_satu = R.drawable.gitaris,
            text_jasa_dua = "Drummer",
            jasa_dua = R.drawable.drum,
            text_jasa_tiga = "Pianis",
            jasa_tiga = R.drawable.pianis
        ),
        KategoriJasa(
            id = 3,
            name = "Desain",
            photo = R.drawable.gambar_desain,
            text_jasa_satu = "Graphic Design",
            jasa_satu = R.drawable.graphic_design,
            text_jasa_dua = "Illustrator Designer",
            jasa_dua = R.drawable.illustrator,
            text_jasa_tiga = "Brand Identity Designer",
            jasa_tiga = R.drawable.brand_identity
        ),
        KategoriJasa(
            id = 4,
            name = "Event",
            photo = R.drawable.gambar_event,
            text_jasa_satu = "Host/MC",
            jasa_satu = R.drawable.host,
            text_jasa_dua = "Decorator",
            jasa_dua = R.drawable.decorator,
            text_jasa_tiga = "Stage Manager",
            jasa_tiga = R.drawable.stage_manager
        ),
    )
}


