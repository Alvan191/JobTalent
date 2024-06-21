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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.API_Network.RegisterRequest
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.data.ViewModel.RegisterViewModel
import com.example.jobtalent.navigation.Screen
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
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
    var message by remember { mutableStateOf("") }

    var katasandiVisible by remember { mutableStateOf(false) }
    var konfirmasiKataSandiVisible by remember { mutableStateOf(false) }

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

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = username,
            onValueChange = {
                username = it
            }, label = {
                Text(
                    text = "Username",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAEAEAE),
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFAEAEAE),
                unfocusedBorderColor = Color(0xFFAEAEAE),
                containerColor = Color(0xFFF5F5F5),
            )
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            }, label = {
                Text(
                    text = "E-mail",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAEAEAE),
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFAEAEAE),
                unfocusedBorderColor = Color(0xFFAEAEAE),
                containerColor = Color(0xFFF5F5F5),
            )
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(
                    text = "Kata Sandi",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAEAEAE),
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFAEAEAE),
                unfocusedBorderColor = Color(0xFFAEAEAE),
                containerColor = Color(0xFFF5F5F5),
            ),
            visualTransformation = if (katasandiVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (katasandiVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (katasandiVisible) "Hide password" else "Show password"

                IconButton(onClick = { katasandiVisible = !katasandiVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
        )

        Spacer(modifier = Modifier.height(14.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = confPassword,
            onValueChange = {
                confPassword = it
            },
            label = {
                Text(
                    text = "Konfirmasi Kata Sandi",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAEAEAE),
                    )
                )
                    },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFAEAEAE),
                unfocusedBorderColor = Color(0xFFAEAEAE),
                containerColor = Color(0xFFF5F5F5),
            ),
            visualTransformation = if (konfirmasiKataSandiVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (konfirmasiKataSandiVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (konfirmasiKataSandiVisible) "Hide password" else "Show password"

                IconButton(onClick = { konfirmasiKataSandiVisible = !konfirmasiKataSandiVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
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
                            confPassword = confPassword
                        )
                        viewModel.registerUser(request, {
                            val sharedPreferencesManager = SharedPreferencesManager(context)
                            sharedPreferencesManager.name = it.username
                            navController.navigate(Screen.Login.route)
                            Toast.makeText(context, "Registration Success : ${it.username}", Toast.LENGTH_SHORT).show()
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

@Preview
@Composable
private fun RegisterScreenPreview() {
    RegistrasiScreen(navController = rememberNavController())
}