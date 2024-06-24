package com.example.jobtalent.presentation.profile.detail_profile


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.datastore.DataStore
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.navigation.Screen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val dataStore = DataStore(context)

    var namaLengkap by remember { mutableStateOf("") }
    var nomorTelepon by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var kataSandi by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxSize()
            .padding(15.dp)
    ){
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Akun Saya",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000)
                            ),
                            modifier = Modifier.padding(start = 15.dp)
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        Color(0xFFFFFFFF)
                    ),
                    navigationIcon = {
                        Box(
                            modifier = Modifier
                                .size(44.dp)
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
                    .background(Color(0xFFFFFFFF))
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFFFFFF))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Nama Lengkap",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        )
                    )
                    OutlinedTextField(
                        value = namaLengkap,
                        onValueChange = { namaLengkap = it },
                        label = { Text("") },
                        textStyle = TextStyle(color = Color(0xFF000000)),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.user1),
                                contentDescription = "Nama Lengkap",
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Nomor Telepon",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        )
                    )
                    OutlinedTextField(
                        value = nomorTelepon,
                        onValueChange = { nomorTelepon = it },
                        label = { Text("") },
                        textStyle = TextStyle(color = Color(0xFF000000)),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.phone),
                                contentDescription = "Nomor Telepon",
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Email",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        )
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("") },
                        textStyle = TextStyle(color = Color(0xFF000000)),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "Email",
                                modifier = Modifier.size(20.dp)
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Kata Sandi",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        )
                    )
                    OutlinedTextField(
                        value = kataSandi,
                        onValueChange = { kataSandi = it },
                        label = { Text("") },
                        textStyle = TextStyle(color = Color(0xFF000000)),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.password),
                                contentDescription = "Kata Sandi",
                                modifier = Modifier.size(30.dp)
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row (
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Button(
                            modifier = Modifier
                                .width(120.dp)
                                .height(55.dp)
                                .background(
                                    color = Color(0xFF005695),
                                    shape = RoundedCornerShape(size = 10.dp)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF005695)
                            ),

                            onClick = {
                                sharedPreferencesManager.name = namaLengkap
                                coroutineScope.launch {
                                    dataStore.saveStatus(true)
                                }
                                navController.navigate(Screen.Profile.route)
                            }
                        ) {
                            Text(
                                text = "Simpan",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}






@Preview
@Composable
private fun AccountScreenPreview() {
    AccountScreen(navController = rememberNavController())
}