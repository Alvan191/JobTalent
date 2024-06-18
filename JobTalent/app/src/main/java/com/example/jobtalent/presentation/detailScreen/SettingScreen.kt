package com.example.jobtalent.presentation.detailScreen



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.DataStore
import com.example.jobtalent.data.SharedPreferencesManager
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.login.model_login.LoginViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)

    // Menerapkan SharedPreferences
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val dataStore = DataStore(context)

    Column (
        modifier = Modifier
            .background(Color(0xfff8f8f8))
            .fillMaxSize()
            .padding(15.dp)
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Pengaturan",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000)
                            ),
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    },
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
                                .shadow(8.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White)
                                .clickable(onClick = { navController.popBackStack() })
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(24.dp)
                                    .align(Alignment.Center)
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                SettingsItem(
                    iconRes = R.drawable.language,
                    label = "Bahasa",
                    onClick = { navController.navigate(Screen.Bahasasc.route) }
                )
                SettingsItemWithSwitch(
                    iconRes = R.drawable.notifications,
                    label = "Notifikasi",
                    checked = true,
                    onCheckedChange = { }
                )
                SettingsItem(
                    iconRes = R.drawable.logout,
                    label = "Keluar Akun",
                    onClick = {
                        sharedPreferencesManager.clear()
                        coroutineScope.launch {
                            viewModel.logoutUser()
                            dataStore.clearStatus()
                        }
                        navController.navigate(Screen.Login.route){
                            popUpTo(Screen.Profile.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun SettingsItem(iconRes: Int, label: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.NavigateNext,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}

@Composable
fun SettingsItemWithSwitch(iconRes: Int, label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val switchState = remember { mutableStateOf(checked) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                )
        )
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switchState.value,
            onCheckedChange = {
                switchState.value = it
                onCheckedChange(it)
            }
        )
    }
}


@Preview
@Composable
private fun SettingScreenPreview() {
    SettingsScreen(navController = rememberNavController())
}