package com.example.jobtalent.presentation.profile.modeJasa

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import coil.compose.rememberAsyncImagePainter
import com.example.jobtalent.R
import com.example.jobtalent.data.PortofolioItem
import com.example.jobtalent.data.SharedPreferencesManager
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.model.DesainPortofolio
import com.example.jobtalent.presentation.profile.model_view.SharedViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun PortofolioScreen(
    modifier: Modifier,
    navController: NavController,
    sharedViewModel: SharedViewModel,
    isiPorto: List<DesainPortofolio> = PortofolioItem.dataPortofolio
) {
    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val currentUser = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@") ?: "N/A"

    val namaTampil = if (sharedPreferencesManager.name.isNullOrEmpty()) currentUser else sharedPreferencesManager.name

    var isExpanded by remember { mutableStateOf(false) }
    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberAsyncImagePainter(
        imageUri.value.ifEmpty { R.drawable.person_profile }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imageUri.value = it.toString()
            sharedViewModel.updateImageUri(it.toString())
        }
    }

    LazyColumn {
        item {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height = 205.dp)
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
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.End,
                    ){
                        Box(
                            modifier = Modifier
                                .size(37.dp)
                                .shadow(8.dp, CircleShape)
                                .clip(CircleShape)
                                .background(Color.White)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Back",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                                    .align(Alignment.Center)
                                    .clickable(onClick = { navController.navigate(Screen.Profile.route) })
                            )
                        }
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(90.dp)
                        ) {
                            Image(
                                painter = painter,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape)
                                    .border(4.dp, Color.White, CircleShape)
                            )
                            Box(
                                modifier = Modifier
                                    .size(30.dp)
                                    .align(Alignment.BottomEnd)
                                    .zIndex(1f)
                                    .shadow(8.dp, CircleShape)
                                    .clip(CircleShape)
                                    .background(Color(0xFFD6D6D6))
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.CameraAlt,
                                    contentDescription = "Camera Icon",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(24.dp)
                                        .clickable(onClick = {launcher.launch("image/*")})
                                )
                            }
                        }
                        Text(
                            text = "$namaTampil",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier
                                .padding(top = 10.dp)
                        )
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .padding(top = 10.dp)
                        ){
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Location",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                            Text(
                                text = "Medan",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFFFFFFFF)
                                )
                            )
                        }
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 22.dp)
                        .padding(top = 10.dp)
                        .shadow(4.dp, RoundedCornerShape(16.dp)),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Text(
                                text = "Tentang Saya",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    lineHeight = 19.2.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF25324B)
                                )
                            )
                            Icon(
                                imageVector = Icons.Default.EditNote,
                                contentDescription = "Edit",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Saya adalah seorang penjahit, ahli dalam menciptakan pakaian dan barang-barang tekstil dengan menggunakan mesin jahit, jarum, dan benang. Pekerjaan saya membutuhkan keterampilan dalam memotong pola, menjahit, dan ${if (isExpanded) "" else "Lihat semua"}",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF515B6F),
                            ),
                            modifier = Modifier.clickable {
                                isExpanded = !isExpanded
                            }
                        )
                        if (isExpanded) {
                            Text(
                                text = "menyelesaikan produk akhir dengan rapi dan presisi.",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    lineHeight = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFF515B6F),
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 2.dp)
                                .background(
                                    color = Color(0xFFD8D8D8),
                                )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Pengalaman",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_black)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF25324B)
                            )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 3.dp)
                        ){
                            Text(
                                text = "Desain Pakaian & Penjahit Kebaya",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF515B6F)
                                ),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Butik Jaya",
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    lineHeight = 19.2.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF515B6F)
                                ),
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text("• ", style = TextStyle(fontSize = 16.sp))
                                Text(
                                    text = "Full-Time",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 19.2.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF515B6F)
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(3.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text("• ", style = TextStyle(fontSize = 16.sp))
                                Text(
                                    text = "Juni 2019 - Juli 2019 (1thn 1bln), Yogyakarta, DIY",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 19.2.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF515B6F)
                                    )
                                )
                            }
                            Spacer(modifier = Modifier.height(3.dp))
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Text("• ", style = TextStyle(fontSize = 16.sp))
                                Text(
                                    text = "Mei 2009 - Sekarang (15thn), Medan",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 19.2.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF515B6F)
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 2.dp)
                                .background(
                                    color = Color(0xFFD8D8D8),
                                )
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Keahlian",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 19.2.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_black)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF25324B)
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Box(
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(20.dp)
                                    .background(
                                        color = Color(0xFFDCE4E9),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Kreatif",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 14.4.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF0060A5)
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(20.dp)
                                    .background(
                                        color = Color(0xFFDCE4E9),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Komunikasi",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 14.4.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF0060A5)
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(20.dp)
                                    .background(
                                        color = Color(0xFFDCE4E9),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Menjahit",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 14.4.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF0060A5)
                                    )
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Row (
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Box(
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(20.dp)
                                    .background(
                                        color = Color(0xFFDCE4E9),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Mendesain",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 14.4.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF0060A5)
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .width(90.dp)
                                    .height(20.dp)
                                    .background(
                                        color = Color(0xFFDCE4E9),
                                        shape = RoundedCornerShape(8.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Permak",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        lineHeight = 14.4.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF0060A5)
                                    )
                                )
                            }
                        }
                    }
                }

                LazyRow (
                    modifier = Modifier
                        .padding(top = 10.dp)
                ){
                    items(isiPorto, key = {it.id}){desain ->
                        RowItemPorto(
                            desain = desain,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowItemPorto(
    modifier: Modifier,
    desain: DesainPortofolio
) {
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
                .width(180.dp)
                .height(165.dp),
            contentAlignment = Alignment.Center
        ){
            Column (){
                Image(
                    painter = painterResource(id = desain.photo),
                    contentDescription = desain.name,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .height(120.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = desain.name,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 19.2.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF797979),

                        )
                )
            }
        }
    }
}

@Preview
@Composable
private fun PortofolioScreenPreview() {
    PortofolioScreen(modifier = Modifier, navController = rememberNavController(), sharedViewModel = SharedViewModel())
}