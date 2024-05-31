package com.example.jobtalent.navigation

sealed class Screen (val route: String){
    data object Splash: Screen ("splash")
    data object Login: Screen ("login")
    data object Register: Screen ("register")
    data object Home: Screen ("home")
    data object Chat: Screen ("chat")
    data object Community: Screen ("community")
    data object Profile: Screen ("profile")
    data object KategoriJasa: Screen ("kategori_jasa")
    data object JenisJasa: Screen ("jenis_jasa")
    data object NamaTampilan: Screen ("nama_tampilan")
    data object Pengalaman: Screen ("pengalaman_anda")
    data object Identitas: Screen ("identitas_anda")
    data object DataPelengkap: Screen ("data_pelengkap")
    data object Portofolios: Screen ("portofolio")
    data object DetailChatsss: Screen ("detail_chat")
    data object JobScreen: Screen ("jobtalent")
}