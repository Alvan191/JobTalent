package com.example.jobtalent

import PaymentSuccessScreen
import TrackingScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Diversity3
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jobtalent.navigation.NavigationItem
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.ChatScreen
import com.example.jobtalent.presentation.CommunityScreen
import com.example.jobtalent.presentation.HomeScreen
import com.example.jobtalent.presentation.ProfileScreen
import com.example.jobtalent.presentation.detailScreen.AccountScreen
import com.example.jobtalent.presentation.detailScreen.DetailChatScreen
import com.example.jobtalent.presentation.detailScreen.LanguageSettingsScreen
import com.example.jobtalent.presentation.detailScreen.NotificationScreen
import com.example.jobtalent.presentation.detailScreen.SettingsScreen
import com.example.jobtalent.presentation.detailScreen.TipsScreen
import com.example.jobtalent.presentation.modeJasa.DataPelengkapScreen
import com.example.jobtalent.presentation.modeJasa.IdentitasScreen
import com.example.jobtalent.presentation.modeJasa.JenisJasaScreen
import com.example.jobtalent.presentation.modeJasa.KategoriJasaScreen
import com.example.jobtalent.presentation.modeJasa.NamaTampilanScreen
import com.example.jobtalent.presentation.modeJasa.PengalamanScreen
import com.example.jobtalent.presentation.modeJasa.PortofolioScreen
import com.example.jobtalent.presentation.pemesananJasa.KategoriPesananScreen
import com.example.jobtalent.presentation.pemesananJasa.PaymentSummaryScreen

@Composable
fun JobTalentApp(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold (
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute != null &&
                !currentRoute.startsWith(Screen.DetailChatsss.route) &&
                currentRoute != Screen.Notificationn.route &&
                currentRoute != Screen.Tipss.route &&
                currentRoute != Screen.KategoriPesanan.route &&
                currentRoute != Screen.KategoriJasa.route &&
                currentRoute != Screen.JenisJasa.route &&
                currentRoute != Screen.NamaTampilan.route &&
                currentRoute != Screen.Pengalaman.route &&
                currentRoute != Screen.Identitas.route &&
                currentRoute != Screen.DataPelengkap.route &&
                currentRoute != Screen.Portofolios.route
            ) {
                BottomBar(navController, modifier)
            }
        },
        modifier = modifier
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                HomeScreen(modifier = Modifier, navController)
            }
            composable(Screen.Chat.route){
                ChatScreen(modifier = Modifier, navController)
            }
            composable(Screen.Community.route){
                CommunityScreen(modifier = Modifier)
            }
            composable(Screen.Profile.route){
                ProfileScreen(navController, modifier = Modifier)
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
                PortofolioScreen(modifier = Modifier, navController)
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
                PaymentSuccessScreen()
            }
            composable(Screen.Trackingsc.route){
                TrackingScreen()
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier: Modifier
) {
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Chat",
                icon = Icons.Default.ChatBubble,
                screen = Screen.Chat
            ),
            NavigationItem(
                title = "Community",
                icon = Icons.Default.Diversity3,
                screen = Screen.Community
            ),
            NavigationItem(
                title = "Profile",
                icon = Icons.Default.Person,
                screen = Screen.Profile
            )
        )
        navigationItems.map { item ->
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
                icon = { Icon(imageVector = item.icon, contentDescription = item.title)},
                label ={ Text(text= item.title)}
            )
        }
    }
}

@Preview
@Composable
private fun JonTalentPreview() {
    JobTalentApp(modifier = Modifier)
}
