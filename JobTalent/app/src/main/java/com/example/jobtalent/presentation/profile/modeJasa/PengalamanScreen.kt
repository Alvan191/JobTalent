package com.example.jobtalent.presentation.profile.modeJasa

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.Lightbulb
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
import androidx.compose.ui.res.painterResource
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
fun PengalamanScreen(
    modifier: Modifier,
    navController: NavController
) {
    var tentangAnda by remember { mutableStateOf("") }
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
                    text = "Bagikan riwayat pekerjaan Anda, seperti",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF717171),
                    )
                )
                Text(
                    text = "pengalaman kerja dan lainnya",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF717171),
                    )
                )
                Spacer(modifier = Modifier.height(25.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color(0xFFB5E0FF))
                    .border(2.dp, Color(0xFF005695), RoundedCornerShape(8.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = "Lamp Icon",
                        tint = Color(0xFF005695),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Lebih dari 80% klien, membaca profil Anda\nsebelum membuat keputusan untuk memilih Anda",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF005695)
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Tentang Anda",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = tentangAnda,
                onValueChange = { tentangAnda = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp)
                    .border(1.dp, Color(0xFFC2C2C2), RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color(0xFF000000)),
                placeholder = {
                    Text(
                        text = "Tonjolkan kelebihan Anda secara umum untuk\nmembantu calon klien mempertimbangkan\njasa yang Anda tawarkan",
                        style = TextStyle(color = Color.Gray, fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(135.dp))
            Button(
                onClick = { navController.navigate(Screen.Identitas.route) },
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
private fun PengalamanScreenPreview() {
    PengalamanScreen(modifier = Modifier, navController = rememberNavController())
}