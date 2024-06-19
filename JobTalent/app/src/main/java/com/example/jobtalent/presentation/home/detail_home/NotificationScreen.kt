package com.example.jobtalent.presentation.home.detail_home

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun NotificationScreen(
    navController: NavController,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF1F1F1)
            )
    ) {
        Column (
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .background(
                    color = Color(0xFFF1F1F1)
                )
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp)
                ) {
                    Text(
                        text = "Notifikasi",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000),

                            )
                    )
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Lainnya",
                        modifier = Modifier
                            .size(25.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        color = Color(0xFF005695)
                    )
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .padding(start = 15.dp, end = 15.dp, bottom = 15.dp)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "•",
                            style = TextStyle(fontSize = 45.sp),
                            color = Color(0xFFFFFFFF)
                        )
                        Text(
                            text = "Lengkapi profil kamu",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier.padding(top = 2.dp, start = 2.dp)
                        )
                    }
                    Text(
                        text = "Tolong verifikasi informasi profil kamu untuk \nmelanjutkan aplikasi ini",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "waktu",
                            tint = Color(0xFF949494),
                            modifier = Modifier
                                .size(18.dp)
                        )
                        Text(
                            text = "10 min",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF949494)
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        color = Color.White
                    )
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .padding(15.dp)
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Lengkapi profil kamu",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color.Black
                        ),
                        modifier = Modifier
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                    Text(
                        text = "Tolong verifikasi informasi profil kamu untuk \nmelanjutkan aplikasi ini",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(300),
                            color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "waktu",
                            tint = Color(0xFF949494),
                            modifier = Modifier
                                .size(18.dp)
                        )
                        Text(
                            text = "10 min",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF949494)
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun NotificationScreenPrev() {
    NotificationScreen(navController = rememberNavController())
}