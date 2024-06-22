package com.example.jobtalent.data.onboard

import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.OnboardScreenItem

object DataOnboard {

    val OnBoardItems = listOf(
        OnboardScreenItem(
            resId = R.raw.welcome,
            title = "Selamat Datang di Job Talent!",
            description = "Ingin mencari pekerjaan tetapi tidak sesuai minat kamu?         Ayo cari pekerjaanmu di sini!"
        ),
        OnboardScreenItem(
            resId = R.raw.work,
            title = "Cari dan Jadilah Penyedia Jasa Terbaik",
            description = "Mari daftar sebagai penyedia jasa dan temukan klien yang membutuhkan keahlian Anda."
        ),
        OnboardScreenItem(
            resId = R.raw.working,
            title = "Mulai Sekarang",
            description = "Daftar sekarang dan nikmati kemudahan dalam mencari atau menawarkan jasa. Temukan kesempatan baru dan perluas jaringan Anda dengan mudah."
        ),
    )
}