package com.example.jobtalent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jobtalent.presentation.login.LoginScreen
import com.example.jobtalent.presentation.login.RegistrasiScreen
import com.example.jobtalent.presentation.login.SplashScreen
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.ChatScreen
import com.example.jobtalent.presentation.CommunityScreen
import com.example.jobtalent.presentation.HomeScreen
import com.example.jobtalent.presentation.ProfileScreen
import com.example.jobtalent.presentation.detailScreen.DetailChatScreen
import com.example.jobtalent.presentation.modeJasa.DataPelengkapScreen
import com.example.jobtalent.presentation.modeJasa.IdentitasScreen
import com.example.jobtalent.presentation.modeJasa.JenisJasaScreen
import com.example.jobtalent.presentation.modeJasa.KategoriJasaScreen
import com.example.jobtalent.presentation.modeJasa.NamaTampilanScreen
import com.example.jobtalent.presentation.modeJasa.PengalamanScreen
import com.example.jobtalent.presentation.modeJasa.PortofolioScreen
import com.example.jobtalent.ui.theme.JobTalentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobTalentTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.Splash.route,
                    builder = {
                        composable(Screen.Splash.route) {
                            SplashScreen(navController)
                        }
                        composable(Screen.Login.route) {
                            LoginScreen(navController)
                        }
                        composable(Screen.Register.route) {
                            RegistrasiScreen(navController)
                        }
                        composable(Screen.JobScreen.route){
                            JobTalentApp(modifier = Modifier)
                        }
                        composable(Screen.Home.route){
                            HomeScreen(modifier = Modifier, navController)
                        }
                    }
                )
            }
        }
    }
}















//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JobTalentTheme {
//        Greeting("Android")
//    }
//}