package com.example.jobtalent.data

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.IsiTips

object TipsItem {
    val dataTips = listOf(
        IsiTips(
            id = 1,
            name = "1",
            descript = "Jangn terjebak dgn format portofolio yang standar",
            photo = R.drawable.tips_satu
        ),
        IsiTips(
            id = 2,
            name = "2",
            descript = "Selain prestasi, pamerkan bukti profesionalmu",
            photo = R.drawable.tips_empat
        ),
        IsiTips(
            id = 3,
            name = "3",
            descript = "Sederhanakan Portofoliomu",
            photo = R.drawable.tips_tiga
        ),
        IsiTips(
            id = 4,
            name = "4",
            descript = "Jangan Lupa Promosikan Dirimu",
            photo = R.drawable.tips_empat
        ),
        IsiTips(
            id = 5,
            name = "5",
            descript = "Andalkan ‘About Me’ untuk menarik Minat Klien",
            photo = R.drawable.tips_lima
        )
    )
}