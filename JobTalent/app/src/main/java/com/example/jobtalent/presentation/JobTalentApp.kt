package com.example.jobtalent.presentation

import PaymentSuccessScreen
import TrackingScreen
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jobtalent.R
import com.example.jobtalent.navigation.NavigationItem
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.chat.ChatScreen
import com.example.jobtalent.presentation.community.CommunityScreen
import com.example.jobtalent.presentation.home.pemesananJasa.MetodePembayaranScreen
import com.example.jobtalent.presentation.profile.detail_profile.AccountScreen
import com.example.jobtalent.presentation.chat.detail_chat.DetailChatScreen
import com.example.jobtalent.presentation.profile.detail_profile.LanguageSettingsScreen
import com.example.jobtalent.presentation.home.detail_home.NotificationScreen
import com.example.jobtalent.presentation.profile.detail_profile.SettingsScreen
import com.example.jobtalent.presentation.home.detail_home.TipsScreen
import com.example.jobtalent.presentation.home.HomeScreen
import com.example.jobtalent.presentation.login.LoginScreen
import com.example.jobtalent.presentation.login.RegistrasiScreen
import com.example.jobtalent.presentation.login.SplashScreen
import com.example.jobtalent.presentation.profile.modeJasa.DataPelengkapScreen
import com.example.jobtalent.presentation.profile.modeJasa.IdentitasScreen
import com.example.jobtalent.presentation.profile.modeJasa.JenisJasaScreen
import com.example.jobtalent.presentation.profile.modeJasa.KategoriJasaScreen
import com.example.jobtalent.presentation.profile.modeJasa.NamaTampilanScreen
import com.example.jobtalent.presentation.profile.modeJasa.PengalamanScreen
import com.example.jobtalent.presentation.profile.modeJasa.PortofolioScreen
import com.example.jobtalent.presentation.home.pemesananJasa.DetailJasaScreen
import com.example.jobtalent.presentation.home.pemesananJasa.KategoriPesananScreen
import com.example.jobtalent.presentation.home.pemesananJasa.PaymentSummaryScreen
import com.example.jobtalent.presentation.home.pemesananJasa.ReviewsScreen
import com.example.jobtalent.presentation.login.OnboardingScreen
import com.example.jobtalent.presentation.profile.ProfileScreen
import com.example.jobtalent.presentation.profile.detail_profile.HelpCenterScreen
import com.example.jobtalent.presentation.profile.model_view.SharedViewModel
import com.example.jobtalent.utils.shouldShowBottomBar

@Composable
fun JobTalentApp(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
) {
    val sharedViewModel: SharedViewModel = viewModel()

    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold (
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) {contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ){
            composable(Screen.Splash.route){
                SplashScreen(navController)
            }
            composable(Screen.Onboarding.route) {
                OnboardingScreen(navController)
            }
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Register.route) {
                RegistrasiScreen(navController)
            }
            composable(Screen.Home.route){
                HomeScreen(modifier = Modifier, navController)
            }
            composable(Screen.Chat.route){
                ChatScreen(modifier = Modifier, navController)
            }
            composable(Screen.Community.route){
                CommunityScreen(navController, sharedViewModel)
            }
            composable(Screen.Profile.route){
                ProfileScreen(navController, modifier = Modifier, sharedViewModel)
            }
            composable(Screen.Notificationn.route){
                NotificationScreen(navController = navController)
            }
            composable(Screen.Tipss.route){
                TipsScreen(navController = navController)
            }
            composable(Screen.KategoriPesanan.route){
                KategoriPesananScreen(navController = navController)
            }
            composable(Screen.KategoriJasa.route){
                KategoriJasaScreen(modifier = Modifier, navController = navController)
            }
            composable(Screen.JenisJasa.route){
                JenisJasaScreen(modifier = Modifier, navController)
            }
            composable(Screen.NamaTampilan.route){
                NamaTampilanScreen(modifier = Modifier, navController)
            }
            composable(Screen.Pengalaman.route){
                PengalamanScreen(modifier = Modifier, navController)
            }
            composable(Screen.Identitas.route){
                IdentitasScreen(modifier = Modifier, navController)
            }
            composable(Screen.DataPelengkap.route){
                DataPelengkapScreen(modifier = Modifier, navController)
            }
            composable(Screen.Portofolios.route){
                PortofolioScreen(modifier = Modifier, navController, sharedViewModel)
            }
            composable(
                Screen.DetailChatsss.route + "/{tampilchatId}",
                arguments = listOf(navArgument("tampilchatId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailChatScreen(
                    navController = navController,
                    tampilchatId = navBackStackEntry.arguments?.getInt("tampilchatId")
                )
            }
            composable(Screen.Settingss.route){
                SettingsScreen(navController)
            }
            composable(Screen.Bahasasc.route){
                LanguageSettingsScreen(navController)
            }
            composable(Screen.Accountsc.route){
                AccountScreen(navController)
            }
            composable(Screen.Paymentsum.route){
                PaymentSummaryScreen(navController)
            }
            composable(Screen.Paymentsucc.route){
                PaymentSuccessScreen(navController)
            }
            composable(Screen.Trackingsc.route){
                TrackingScreen(navController)
            }
            composable(Screen.Ratingsc.route){
                RatingJasa(navController)
            }
            composable(Screen.Metodepayment.route){
                MetodePembayaranScreen(navController)
            }
            composable(Screen.Postingdet.route){
                Postingan(navController)
            }
            composable(Screen.Komentarsc.route){
                KomentarScreen(navController)
            }
            composable(Screen.DetJasa.route){
                DetailJasaScreen(navController)
            }
            composable(Screen.Reviewsc.route){
                ReviewsScreen(navController)
            }
            composable(Screen.PusatBantu.route){
                HelpCenterScreen(navController)
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar (
        modifier = modifier,
        containerColor = Color.White
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Beranda",
                iconBlack = R.drawable.home_black,
                iconBlue = R.drawable.home_blue,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Pesan",
                iconBlack = R.drawable.chat_black,
                iconBlue = R.drawable.chat_blue,
                screen = Screen.Chat
            ),
            NavigationItem(
                title = "Komunitas",
                iconBlack = R.drawable.community_black,
                iconBlue = R.drawable.community_blue,
                screen = Screen.Community
            ),
            NavigationItem(
                title = "Profil",
                iconBlack = R.drawable.person_black,
                iconBlue = R.drawable.person_blue,
                screen = Screen.Profile
            )
        )
        navigationItems.map { item ->
            val iconRes = if (currentRoute == item.screen.route) {
                item.iconBlue
            } else {
                item.iconBlack
            }

            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick ={
                    navController.navigate(item.screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState =true
                        launchSingleTop =true
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(id = iconRes),
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (currentRoute == item.screen.route) Color(0xFF005695) else Color.Black,
                        fontWeight = if (currentRoute == item.screen.route) FontWeight.Bold else FontWeight.Normal,
                        fontSize = if (currentRoute == item.screen.route) 14.sp else 13.sp,
                        fontFamily = if (currentRoute == item.screen.route) FontFamily(Font(R.font.roboto_medium)) else FontFamily(Font(
                            R.font.roboto_light
                        )),
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun JonTalentPreview() {
    JobTalentApp(modifier = Modifier)
}
