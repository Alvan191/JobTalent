package com.example.jobtalent.data.item

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriBrandIdentity
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriDecorator
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriDrummer
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriGitaris
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriGraphicDesigner
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriIllustrator
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriMC
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriPemangkas
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriPenjahit
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriPianis
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriServis
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriStageManager

object KatPesananItemUMKM {
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

object KatPesananItemMusisi {
    val dataGitaris = listOf(
        KategoriGitaris(
            id = 1,
            name = "Janeth",
            talent = "Gitaris",
            photo = R.drawable.janeth
        ),
        KategoriGitaris(
            id = 2,
            name = "Fiko",
            talent = "Gitaris",
            photo = R.drawable.fiko
        ),
        KategoriGitaris(
            id = 3,
            name = "Ryan",
            talent = "Gitaris",
            photo = R.drawable.ryan
        ),
    )

    val dataDrummer = listOf(
        KategoriDrummer(
            id = 1,
            name = "Neil",
            talent = "Drummer",
            photo = R.drawable.neil
        ),
        KategoriDrummer(
            id = 2,
            name = "Joy",
            talent = "Drummer",
            photo = R.drawable.joyyy
        ),
        KategoriDrummer(
            id = 3,
            name = "Tony",
            talent = "Drummer",
            photo = R.drawable.tony
        ),
    )

    val dataPianis = listOf(
        KategoriPianis(
            id = 1,
            name = "Saudara Barsama",
            talent = "Pianis",
            photo = R.drawable.image_satu
        ),
        KategoriPianis(
            id = 2,
            name = "Arya S.",
            talent = "Pianis",
            photo = R.drawable.image_dua
        ),
        KategoriPianis(
            id = 3,
            name = "Junaidi",
            talent = "Pianis",
            photo = R.drawable.image_tiga
        ),
    )
}

object KatPesananItemEvent {
    val dataMC = listOf(
        KategoriMC(
            id = 1,
            name = "Arsy",
            talent = "Host",
            photo = R.drawable.arsy
        ),
        KategoriMC(
            id = 2,
            name = "Boy",
            talent = "Host",
            photo = R.drawable.boyy
        ),
        KategoriMC(
            id = 3,
            name = "Brune",
            talent = "Host",
            photo = R.drawable.brunne
        ),
    )

    val dataDecorator = listOf(
        KategoriDecorator(
            id = 1,
            name = "Sipapasi",
            talent = "Decorator",
            photo = R.drawable.sipapasi
        ),
        KategoriDecorator(
            id = 2,
            name = "Dwi",
            talent = "Pasipage",
            photo = R.drawable.pasipaga
        ),
        KategoriDecorator(
            id = 3,
            name = "Gugugaga",
            talent = "Decorator",
            photo = R.drawable.gugugaga
        ),
    )

    val dataStageManager = listOf(
        KategoriStageManager(
            id = 1,
            name = "Boris",
            talent = "Stage Manager",
            photo = R.drawable.boris
        ),
        KategoriStageManager(
            id = 2,
            name = "Fian",
            talent = "Stage Manager",
            photo = R.drawable.fiann
        ),
        KategoriStageManager(
            id = 3,
            name = "Evan",
            talent = "Stage Manager",
            photo = R.drawable.evan
        ),
    )
}

object KatPesananItemDesain {
    val dataGraphicDesign = listOf(
        KategoriGraphicDesigner(
            id = 1,
            name = "Arumi",
            talent = "Graphic Designer",
            photo = R.drawable.arumi
        ),
        KategoriGraphicDesigner(
            id = 2,
            name = "Gilang Dirga",
            talent = "Graphic Designer",
            photo = R.drawable.gilang
        ),
    )

    val dataIllustrator = listOf(
        KategoriIllustrator(
            id = 1,
            name = "Muhammad Antoni",
            talent = "Illustrator",
            photo = R.drawable.antoni
        ),
        KategoriIllustrator(
            id = 2,
            name = "Dwi",
            talent = "Illustrator",
            photo = R.drawable.dwi
        ),
    )

    val dataBrandIdentity = listOf(
        KategoriBrandIdentity(
            id = 1,
            name = "Muhammad Aidil",
            talent = "Brand Identity Designer",
            photo = R.drawable.boris
        ),
        KategoriBrandIdentity(
            id = 2,
            name = "Sintia",
            talent = "Brand Identity Designer",
            photo = R.drawable.shintia
        ),
    )
}