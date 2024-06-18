package com.example.jobtalent.presentation.profile.modeJasa

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NamaTampilanScreen(
    modifier: Modifier,
    navController: NavController
) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var rangeTarif by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Daftar Penyedia Jasa",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Berikan informasi dasar untuk membangun",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF717171),
                    )
                )
                Text(
                    text = "kredibilitas Anda",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF717171),
                    )
                )
            }
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Nama Yang Digunakan Untuk Tampilan Sistem",
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = nama,
                onValueChange = { nama = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(1.dp, Color(0xFFCFCFCF), RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(
                        text = "Masukkan Nama Lengkap",
                        style = TextStyle(color = Color.Gray, fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Email",
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(1.dp, Color(0xFFCFCFCF), RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(
                        text = "Masukkan Email",
                        style = TextStyle(color = Color.Gray, fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "No Telepon",
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = noTelepon,
                onValueChange = { noTelepon = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(1.dp, Color(0xFFCFCFCF), RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(
                        text = "Masukkan No Telepon",
                        style = TextStyle(color = Color.Gray, fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Range Tarif",
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = rangeTarif,
                onValueChange = { rangeTarif = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(1.dp, Color(0xFFCFCFCF), RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(
                        text = "Masukkan Range Tarif Jasa",
                        style = TextStyle(color = Color.Gray, fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(135.dp))
            Button(
                onClick = { navController.navigate(Screen.Pengalaman.route) },
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .background(
                        color = Color(0xFF005695),
                        shape = RoundedCornerShape(size = 8.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF005695)
                ),
            ) {
                Text(
                    text = "Selanjutnya",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(650),
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview
@Composable
private fun NamaTampilanScreenPreview() {
    NamaTampilanScreen(modifier = Modifier, navController = rememberNavController())
}