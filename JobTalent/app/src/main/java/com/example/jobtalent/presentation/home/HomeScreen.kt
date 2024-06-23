package com.example.jobtalent.presentation.home

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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.navigation.Screen
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val currentUser = sharedPreferencesManager.email?.substringBefore("@") ?: "N/A"
    val namaTampil = if (sharedPreferencesManager.name.isNullOrEmpty()) currentUser else sharedPreferencesManager.name

    val currentDate = LocalDate.now()
    val dayOfWeek = currentDate.dayOfWeek.getDisplayName(java.time.format.TextStyle.SHORT, Locale("id", "ID"))
    val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("d MMM yyyy", Locale("id", "ID")))
    val displayText = "$dayOfWeek, $formattedDate"


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF8F8F8)
            ),
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                .background(
                    color = Color(0xFFF8F8F8)
                ),
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = buildAnnotatedString {
                            append("Hi, ")
                            withStyle(style = SpanStyle(MaterialTheme.colorScheme.primary)) {
                                append("$namaTampil 😍")
                            }
                        },
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000),
                        )
                    )
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notification Icon",
                        tint = Color(0xFF005695),
                        modifier = Modifier
                            .clickable { navController.navigate(Screen.Notificationn.route) }
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Calendar",
                        tint = Color(0xFF848484),
                    )
                    Text(
                        text = displayText,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF848484),
                        )
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 8.dp)
                ) {
                    var searchText by remember { mutableStateOf("") }
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                tint = Color(0xFF848484),
                            )
                        },
                        placeholder = { Text(text = "Cari Pekerjaan", color = Color(0xFF848484)) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                            .height(50.dp)
                            .shadow(8.dp, RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp)),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Tips untuk kamu",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )

                Box(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(height = 175.dp)
                        .clip(RoundedCornerShape(8.dp))
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
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column {
                            Text(
                                text = "Cara membuat portofolio \nyang sempurna untuk Anda",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 25.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                )
                            )
                            Spacer(modifier = Modifier.height(25.dp))
                            Button(
                                onClick = { navController.navigate(Screen.Tipss.route) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFBDEBF1)
                                ),
                                shape = RoundedCornerShape(4.dp),
                                modifier = Modifier.padding(top = 8.dp)
                            ) {
                                Text(
                                    text = "Lihat",
                                    style = TextStyle(
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF1E1E1E),
                                    )
                                )
                            }
                        }
                        Image(
                            painter = painterResource(id = R.drawable.gambar_iklan),
                            contentDescription = "image description",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(width = 108.dp)
                                .height(height = 160.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                }
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Kategori",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    CardItemHm(
                        img_hm = R.drawable.umkm,
                        label = "UMKM",
                        description = "Tersedia 50 Jasa",
                        onClick = {navController.navigate(Screen.KategoriPesananUMKM.route)}
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    CardItemHm(
                        img_hm = R.drawable.musisi,
                        label = "Musisi",
                        description = "Tersedia 30 Jasa",
                        onClick = {navController.navigate(Screen.KategoriPesananMusisi.route)}
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    CardItemHm(
                        img_hm = R.drawable.event,
                        label = "Event",
                        description = "Tersedia 15 Jasa",
                        onClick = {navController.navigate(Screen.KategoriPesananEvent.route)}
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    CardItemHm(
                        img_hm = R.drawable.desain,
                        label = "Desain",
                        description = "Tersedia 25 Jasa",
                        onClick = {navController.navigate(Screen.KategoriPesananDesign.route)}
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Kemajuan Terbaru",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                TrackingItem(
                    img_tr = R.drawable.anto,
                    name = "Anto",
                    skill = "Penjahit",
                    progres = "Proses Pengerjaan",
                    onClick = { navController.navigate(Screen.Trackingsc.route)}
                )

                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun CardItemHm(img_hm: Int, label: String, description: String, onClick: () -> Unit) {
    Column (
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(10.dp)
    ){
        Card(
            modifier = Modifier
                .clickable(onClick = onClick)
                .width(160.dp)
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = img_hm),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(width = 145.dp, height = 100.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = label,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF979797),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun TrackingItem(img_tr: Int, name: String, skill: String, progres: String, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .clickable (onClick = onClick),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(height = 160.dp)
                .background(
                    color = Color.White
                )
        ) {
            Column (
                modifier = Modifier.fillMaxWidth()
            ){
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = img_tr),
                        contentDescription = "image description",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                text = name,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000)
                                )
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = skill,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(600),
                                    color = Color(0xFFB2B2B2)
                                )
                            )
                        }
                        Icon(
                            imageVector = Icons.Default.NavigateNext,
                            contentDescription = "next",
                            tint = Color(0xFF000000),
                            modifier = Modifier
                                .size(35.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = progres,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        fontWeight = FontWeight(800),
                        color = Color(0xFF2D8F49)
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.tracksec),
                    contentDescription = "tracking",
                    modifier = Modifier
                        .padding(top = 20.dp, start = 10.dp, end = 10.dp)
                        .fillMaxWidth()
                        .height(19.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Diterima",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Text(
                            text = "Apr 03, 2024 ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(300),
                                color = Color(0xFF000000)
                            )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(top = 10.dp)
                    ) {
                        Text(
                            text = "Selesai",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Text(
                            text = "Apr 05, 2024 ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(300),
                                color = Color(0xFF000000)
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
private fun HomeScreenPreview() {
    HomeScreen(modifier = Modifier, navController = rememberNavController())
}