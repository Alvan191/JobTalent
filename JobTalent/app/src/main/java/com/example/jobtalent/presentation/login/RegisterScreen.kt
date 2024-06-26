package com.example.jobtalent.presentation.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.API_Network.RegisterRequest
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.data.ViewModel.RegisterViewModel
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.login.componentLogin.ContentForm
import kotlinx.coroutines.launch

@Composable
fun RegistrasiScreen(
    navController: NavController,
    viewModel: RegisterViewModel = viewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confPassword by remember { mutableStateOf("") }
    val status = "seeker"


    var message by remember { mutableStateOf("") }
    var katasandiVisible by remember { mutableStateOf(false) }
    var konfirmasiKataSandiVisible by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFFFFFF)
            ),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(
                    color = Color(0xFFFFFFFF)
                ),
            verticalArrangement = Arrangement.Center,

            ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_login),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(150.dp)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Daftar",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000)
                )
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Masukkan email dan kata sandi dengan benar",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ContentForm(
                value = username,
                onValueChange = { username = it },
                labelText = "Username",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            ContentForm(
                value = email,
                onValueChange = { email = it },
                labelText = "E-mail",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(14.dp))

            ContentForm(
                value = password,
                onValueChange = { password = it },
                labelText = "Kata Sandi",
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                katasandiVisible = remember { mutableStateOf(katasandiVisible) }
            )

            Spacer(modifier = Modifier.height(14.dp))
            ContentForm(
                value = confPassword,
                onValueChange = { confPassword = it },
                labelText = "Konfirmasi Kata Sandi",
                modifier = Modifier.fillMaxWidth(),
                isPassword = true,
                katasandiVisible = remember { mutableStateOf(konfirmasiKataSandiVisible) }
            )

            Spacer(modifier = Modifier.height(70.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(color = Color(0xFF005695), shape = RoundedCornerShape(size = 5.dp))
                    .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF005695)
                ),
                onClick = {
                    coroutineScope.launch {
                        if (email.isBlank() || password.isBlank()) {
                            Toast.makeText(
                                context,
                                "Email dan Password Wajib Diisi",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        } else if (password != confPassword) {
                            Toast.makeText(
                                context,
                                "Password dan Konfirmasi Password tidak cocok",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val request = RegisterRequest(
                                username = username,
                                email = email,
                                password = password,
                                confPassword = confPassword,
                                status = status
                            )
                            viewModel.registerUser(request, {
                                val sharedPreferencesManager = SharedPreferencesManager(context)
                                sharedPreferencesManager.name = it.username
                                navController.navigate(Screen.Login.route)
                                Toast.makeText(
                                    context,
                                    "Registration Success : ${it.username}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }, {
                                message = "Registration Failed : $it"
                            })
                        }
                    }
                },
            ) {
                Text(
                    text = "Daftar",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                    )
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sudah punya akun? ",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "Masuk",
                    modifier = Modifier.clickable { navController.navigate(Screen.Login.route) },
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF0097B2),
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegistrasiScreen(navController = rememberNavController())
}