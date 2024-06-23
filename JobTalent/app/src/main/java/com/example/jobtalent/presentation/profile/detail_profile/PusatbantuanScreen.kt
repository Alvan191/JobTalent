package com.example.jobtalent.presentation.profile.detail_profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpCenterScreen(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFFFFF))
                .padding(top = 20.dp)
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = "Pusat Bantuan",
                                textAlign = TextAlign.Center,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF000000),
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            Color(0xFFFFFFFF)
                        ),
                        navigationIcon = {
                            Box(
                                modifier = Modifier
                                    .size(38.dp)
                                    .padding(start = 10.dp)
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
                        },
                        actions = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Default.MoreVert, contentDescription = "More")
                            }
                        }
                    )
                },
                content = { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFFFFFFFF))
                            .padding(innerPadding)
                            .padding(start = 16.dp, end = 16.dp, top = 28.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Apa yang bisa kami bantu?",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000),
                            )
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        val textState = remember { mutableStateOf(TextFieldValue()) }
                        OutlinedTextField(
                            value = textState.value,
                            onValueChange = { textState.value = it },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Search,
                                    contentDescription = "Search Icon",
                                    tint = Color(0x6B717171)
                                )
                            },
                            placeholder = {
                                Text(
                                    text = "Telusuri pusat bantuan",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0x6B717171),
                                    )
                                )
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = Color(0x6B717171),
                                unfocusedBorderColor = Color(0x6B717171)
                            )
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Temukan solusi di artikel",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF000000)
                            ),
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                        )
                        ArticleItem(title = "Cara Membatalkan Pemesanan Penyedia Jasa")
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        ArticleItem(title = "Pengembalian Dana (Refund) Belum Diterima")
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 25.dp)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        ArticleItem(title = "Saya Belum Terima Hasil Jasa")
                    }
                },
                bottomBar = {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Button(
                            onClick = { },
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .padding(end = 20.dp, bottom = 20.dp)
                                .width(185.dp)
                                .height(52.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005695))
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Icon(
                                    imageVector = Icons.Default.HelpCenter,
                                    contentDescription = "HelpCenter",
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(
                                    text = "Hubungi Kami",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFFFFFFFF),
                                    )
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun ArticleItem(title: String) {
    Column (
        modifier = Modifier.wrapContentSize().background(Color(0xFFFFFFFF))
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Article,
                contentDescription = null,
                tint = Color(0xFF005695),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000),
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelpCenterScreen(navController = rememberNavController())
}
