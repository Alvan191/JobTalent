package com.example.jobtalent.presentation.pemesananJasa

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentSummaryScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "    Ringkasan Pembayaran",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),

                            )
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
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Nama Penyedia Jasa",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000)
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "User Image",
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text(
                                text = "Anto Ramadhan",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000)
                                )
                            )
                            Text(
                                text = "Penjahit",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(800),
                                    color = Color(0xFFB2B2B2)
                                )
                            )
                        }
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Detail Jasa",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000)
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Menjahit baju kebaya wisuda",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(800),
                            color = Color(0xFF000000),

                            )
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                var paymentAmount by remember { mutableStateOf("") }
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Nominal Pembayaran",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000)
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = paymentAmount,
                            onValueChange = { paymentAmount = it },
                            placeholder = { Text("Rp.") },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                containerColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Jumlah sesuai tarif yang telah disepakati.",
                            style = TextStyle(
                                fontSize = 9.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(500),
                                color = Color(0x6E000000),

                                )
                        )
                    }
                }
            }
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dana),
                        contentDescription = "Payment Method",
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "08********",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Text(
                            text = "Dana",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(color = Color(0xFF005695), shape = RoundedCornerShape(size = 5.dp))
                    .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF005695)
                ),
                onClick = { navController.navigate(Screen.Paymentsucc.route) }
            ) {
                Text(
                    text = "Lakukan Pembayaran",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}



@Preview
@Composable
private fun PaymentSummaryScreenPreview() {
    PaymentSummaryScreen(navController = rememberNavController())
}