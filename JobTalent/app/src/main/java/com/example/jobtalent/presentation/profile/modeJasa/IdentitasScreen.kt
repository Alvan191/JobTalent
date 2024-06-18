package com.example.jobtalent.presentation.profile.modeJasa

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FileUpload
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun IdentitasScreen(
    modifier: Modifier,
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ) {
        item {
            Column (
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxSize()
                    .background(
                        color = Color.White
                    )
            ){
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
                        .fillMaxSize(),
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
                        text = "Konfirmasi Identitas Anda",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF717171),
                        )
                    )
                    Spacer(modifier = Modifier.height(16.dp))


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .padding(top = 15.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "Foto selfie dengan KTP",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color.Black
                                    )
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Detail terlihat dengan jelas dan pemilik KTP memegang kartu identitasnya sendiri",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF717171),
                                    )
                                )
                                Spacer(modifier = Modifier.height(6.dp))

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.gambar_fotoktp),
                                        contentDescription = "foto ktp",
                                        modifier = Modifier
                                            .height(180.dp)
                                            .fillMaxWidth()
                                            .padding(horizontal = 23.dp)
                                    )

                                    Button(
                                        onClick = { },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 20.dp)
                                            .height(50.dp),
                                        border = BorderStroke(1.dp, Color(0xFF005695)),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White
                                        ),
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.FileUpload,
                                                contentDescription = "File Upload",
                                                tint = Color(0xFF005695)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "Unggah Foto",
                                                style = TextStyle(color = Color(0xFF005695))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .clip(RoundedCornerShape(8.dp))
                                .background(Color.White)
                                .padding(top = 15.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                            ) {
                                Text(
                                    text = "Foto KTP",
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color.Black
                                    )
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "Detail KTP terlihat dengan jelas",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF717171),
                                    )
                                )
                                Spacer(modifier = Modifier.height(6.dp))

                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.gambar_ktp),
                                        contentDescription = "gambar ktp",
                                        modifier = Modifier
                                            .height(180.dp)
                                            .fillMaxWidth()
                                            .padding(horizontal = 23.dp)
                                    )

                                    Button(
                                        onClick = { },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 20.dp)
                                            .height(50.dp),
                                        border = BorderStroke(1.dp, Color(0xFF005695)),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White
                                        ),
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.FileUpload,
                                                contentDescription = "File Upload",
                                                tint = Color(0xFF005695)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text(
                                                text = "Unggah Foto",
                                                style = TextStyle(color = Color(0xFF005695))
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { navController.navigate(Screen.DataPelengkap.route) },
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
    }
}

@Preview
@Composable
private fun IdentitasScreenPreview() {
    IdentitasScreen(modifier = Modifier, navController = rememberNavController())
}