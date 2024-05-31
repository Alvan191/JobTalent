package com.example.jobtalent.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 325.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF005695),
                                Color(0xFF87CEEB)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        )
                    )
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painterResource(id = R.drawable.anto),
                        contentDescription = "Anto Ramadhan",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .border(4.dp, Color.White, CircleShape)
                            .clickable(onClick = { navController.navigate(Screen.Portofolios.route) })
                    )
                    Text(
                        text = "Anto Ramadhan",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = "anto89@gmail.com",
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_black)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }
            }
        }


        Card(
            modifier = Modifier
                .size(width = 325.dp, height = 550.dp)
                .padding(top = 180.dp)
                .align(Alignment.Center)
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .zIndex(1f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
            ) {
                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                ){

                    item {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "person",
                            tint = Color(0xFF005695),
                            modifier = Modifier
                                .size(32.dp)
                        )
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 3.dp)
                        ){
                            Text(
                                text = "Akun Saya",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF2F2F31)
                                ),
                            )
                            Spacer(modifier = Modifier.width(130.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForwardIos,
                                contentDescription = "arrow next",
                                tint = Color(0xFF005695),
                            )
                        }
                    }
                }

                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 26.dp)
                ){

                    item {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "settings",
                            tint = Color(0xFF005695),
                            modifier = Modifier
                                .size(32.dp)
                        )
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 3.dp)
                        ){
                            Text(
                                text = "Pengaturan",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF2F2F31)
                                ),
                            )
                            Spacer(modifier = Modifier.width(123.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForwardIos,
                                contentDescription = "arrow next",
                                tint = Color(0xFF005695),
                            )
                        }
                    }
                }

                LazyRow (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 26.dp)
                ){

                    item {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "call",
                            tint = Color(0xFF005695),
                            modifier = Modifier
                                .size(32.dp)
                        )
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 3.dp)
                        ){
                            Text(
                                text = "Hubungi",
                                style = TextStyle(
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF2F2F31)
                                ),
                            )
                            Spacer(modifier = Modifier.width(148.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowForwardIos,
                                contentDescription = "arrow next",
                                tint = Color(0xFF005695),
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(135.dp))
                Button(
                    onClick = { navController.navigate(Screen.KategoriJasa.route) },
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 19.dp)
                        .background(
                            color = Color(0xFF005695),
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF005695)
                    ),
                    ) {
                    Text(
                        text = "Mode Penyedia Jasa",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(650),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}