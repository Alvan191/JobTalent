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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Discount
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.PortofolioItem
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.model.DesainPortofolio

@Composable
fun DetailJasaScreen(
    navController: NavController,
    isiPorto: List<DesainPortofolio> = PortofolioItem.dataPortofolio
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
    ){
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(305.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_detailjasa),
                    contentDescription = "detail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp)
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

            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 220.dp, bottom = 60.dp)
                    .align(Alignment.Center)
                    .shadow(8.dp)
                    .zIndex(1f),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                ) {
                    Text(
                        text = "Anto Ramadhan",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_black)),
                            fontWeight = FontWeight(700),
                            color = Color(0xFF000000)
                        )
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Penjahit",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF818181)
                            )
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            for (i in 1..5) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Star Icon",
                                    tint = Color(0xFFFFC107),
                                    modifier = Modifier
                                        .size(20.dp)
                                )
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        DetailJasaItemsc(
                            icon = Icons.Default.LocationOn,
                            desc = "Thamrin",
                            label = "Lokasi"
                        )
                        DetailJasaItemsc(
                            icon = Icons.Default.Discount,
                            desc = "200rb - 2jt",
                            label = "Harga"
                        )
                        DetailJasaItemsc(
                            icon = Icons.Default.People,
                            desc = "99",
                            label = "Total Klien"
                        )
                    }
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(bottom = 20.dp)
                    ){

                        item {
                            Text(
                                text = "Tentang Saya",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF000000),
                                )
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                            Text(
                                text = "Saya Anto Ramadhan, Saya adalah seorang pengusaha kecil spesialis dalam menjahit. Dengan pengalaman yang telah saya kumpulkan selama bertahun-tahun, saya telah membantu berbagai klien untuk mencapai tujuan mereka dengan hasil yang memuaskan... Lihat semua",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(800),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Justify,
                                )
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            Text(
                                text = "Portofolio",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFF000000)
                                )
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            LazyRow(
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            ) {
                                items(isiPorto, key = { it.id }) { desain ->
                                    RowItemPortoo(
                                        desain = desain,
                                        modifier = Modifier
                                    )
                                }
                            }
                        }

                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Ulasan",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF000000),
                                    )
                                )
                                Text(
                                    text = "Lihat Semua",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF0060A5),
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Selena Roro",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Justify,
                                    )
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Star Icon",
                                        tint = Color(0xFFFFC107),
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                    Text(
                                        text = "  5.0",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                                            fontWeight = FontWeight(800),
                                            color = Color(0xFF000000),
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, pokoknya sangat recomended lah ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 17.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(800),
                                    color = Color(0xFF000000),

                                    textAlign = TextAlign.Justify,
                                )
                            )
                        }

                        item {
                            Spacer(modifier = Modifier.height(15.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Ridho Kurnia",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Justify,
                                    )
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Star Icon",
                                        tint = Color(0xFFFFC107),
                                        modifier = Modifier
                                            .size(20.dp)
                                    )
                                    Text(
                                        text = "  5.0",
                                        style = TextStyle(
                                            fontSize = 12.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                                            fontWeight = FontWeight(800),
                                            color = Color(0xFF000000),
                                            textAlign = TextAlign.Center,
                                        )
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Wahhhh penjahitnya hebat bangettt... baju saya yang longgar di buat pas dengan ukuran badan saya, dan jahitannya rapi banget, lain kali jahit baju disini aja dehh ehehhe",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 17.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(800),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Justify,
                                )
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .zIndex(1f)
                    .wrapContentHeight()
                    .background(Color.White)
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.Chat.route) },
                        modifier = Modifier
                            .height(45.dp)
                            .weight(1f)
                            .padding(horizontal = 19.dp)
                            .background(
                                color = Color(0xFFD5ECFF),
                                shape = RoundedCornerShape(size = 10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD5ECFF)
                        ),
                    ) {
                        Text(
                            text = "Chat",
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(650),
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = { navController.navigate(Screen.Metodepayment.route) },
                        modifier = Modifier
                            .height(45.dp)
                            .weight(1f)
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
                            text = "Hire",
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

@Composable
fun RowItemPortoo( modifier: Modifier, desain: DesainPortofolio ) {
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Box(
            modifier
                .padding(10.dp)
                .width(125.dp),
            contentAlignment = Alignment.Center
        ){
            Column (){
                Image(
                    painter = painterResource(id = desain.photo),
                    contentDescription = desain.name,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .height(95.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun DetailJasaItemsc(icon: ImageVector, desc: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier
                .size(58.dp)
                .clip(CircleShape)
                .background(Color(0xFFDDEAF5))
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color(0xFF004D84),
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = desc,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(800),
                color = Color(0xFF818181),
            )
        )
    }
}

@Preview
@Composable
private fun DetailJasaScreenPrev() {
    DetailJasaScreen(navController = rememberNavController())
}