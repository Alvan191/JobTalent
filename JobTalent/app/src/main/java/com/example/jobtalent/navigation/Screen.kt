package com.example.jobtalent.navigation

sealed class Screen (val route: String){
    data object Splash: Screen ("splash")
    data object Login: Screen ("login")
    data object Register: Screen ("register")
    data object Home: Screen ("home")
    data object Chat: Screen ("chat")
    data object Community: Screen ("community")
    data object Profile: Screen ("profile")
    data object Notificationn: Screen ("notifikasi")
    data object Tipss: Screen ("tips")
    data object KategoriPesanan: Screen ("kategori_pesanan")
    data object KategoriJasa: Screen ("kategori_jasa")
    data object JenisJasa: Screen ("jenis_jasa")
    data object NamaTampilan: Screen ("nama_tampilan")
    data object Pengalaman: Screen ("pengalaman_anda")
    data object Identitas: Screen ("identitas_anda")
    data object DataPelengkap: Screen ("data_pelengkap")
    data object Portofolios: Screen ("portofolio")
    data object DetailChatsss: Screen ("detail_chat")
    data object JobScreen: Screen ("jobtalent")
    data object Settingss: Screen ("setting")
    data object Bahasasc: Screen ("bahasa_screen")
    data object Accountsc: Screen ("akun_screen")
    data object Paymentsum: Screen ("payment_summary")
    data object Paymentsucc: Screen ("payment_succes")
    data object Trackingsc: Screen ("tracking_screen")
    data object Ratingsc: Screen ("rating_screen")
    data object Metodepayment: Screen ("metode_pembayaran_screen")
    data object Komentarsc: Screen ("komentar_screen")
    data object Postingdet: Screen ("detail_postingan")
    data object DetJasa: Screen ("detail_pesanan_jasa")
}