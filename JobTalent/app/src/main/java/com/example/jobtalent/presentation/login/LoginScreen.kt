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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.API_Network.LoginRequest
import com.example.jobtalent.data.datastore.DataStore
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.data.ViewModel.LoginViewModel
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.login.componentLogin.ContentForm
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val dataStore = DataStore(context)

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var katasandiVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Image",
                modifier = Modifier
                    .size(130.dp)
            )
        }

        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Masuk",
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
            value = email,
            onValueChange = { email = it },
            labelText = "E-mail",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        ContentForm(
            value = password,
            onValueChange = { password = it },
            labelText = "Kata Sandi",
            modifier = Modifier.fillMaxWidth(),
            isPassword = true,
            katasandiVisible = remember { mutableStateOf(katasandiVisible) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Lupa Kata Sandi?",
                modifier = Modifier.clickable { },
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
        }

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
                    } else {
                        val request = LoginRequest(
                            email = email,
                            password = password
                        )
                        sharedPreferencesManager.email = email
                        viewModel.loginUser(request, {
                            coroutineScope.launch {
                                dataStore.saveStatus(true)
                            }
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Login.route) {
                                    inclusive = true
                                }
                            }
                            Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT)
                                .show()
                        }, {
                            Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                        })
                    }
                }
            },
        ) {
            Text(
                text = "Masuk",
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
                text = "Tidak punya akun? ",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )
            Spacer(modifier = Modifier.width(2.dp))
            Text(
                text = "Daftar",
                modifier = Modifier.clickable { navController.navigate(Screen.Register.route) },
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


@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}