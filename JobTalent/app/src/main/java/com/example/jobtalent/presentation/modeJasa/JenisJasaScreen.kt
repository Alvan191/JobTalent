package com.example.jobtalent.presentation.modeJasa

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.layout.ContentScale
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
fun JenisJasaScreen(
    modifier: Modifier,
    navController: NavController
) {
    Column (
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
                text = "Pilih jenis jasa yang ingin Anda tawarkan",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF717171),
                )
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(40.dp)
                .padding(8.dp)
                .border(1.dp, Color(0xFF005695), RoundedCornerShape(10.dp))
        ) {
            Box(
                modifier = Modifier
                    .size(width = 90.dp, height = 39.dp)
                    .background(Color.White, RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "UMKM",
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))


        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .clickable(onClick = {navController.navigate(Screen.NamaTampilan.route)})
        ){
            Card(
                modifier = Modifier
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD9E7F2)
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFFD9E7F2))
                        .clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gambar_jahit),
                        contentDescription = "penjahit",
                        modifier = Modifier.size(39.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp)
            ){
                Text(
                    text = "Penjahit",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F2F31)
                    ),)
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "arrow next",
                    tint = Color(0xFF005695)
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .clickable() {}
        ){
            Card(
                modifier = Modifier
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD9E7F2)
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFFD9E7F2))
                        .clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gambar_pangkas),
                        contentDescription = "pemangkas",
                        modifier = Modifier.size(39.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp)
            ){
                Text(
                    text = "Pemangkas Rambut",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F2F31)
                    ),)
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "arrow next",
                    tint = Color(0xFF005695)
                )
            }
        }
        Spacer(modifier = Modifier.height(18.dp))

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .clickable() {}
        ){
            Card(
                modifier = Modifier
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFD9E7F2)
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color(0xFFD9E7F2))
                        .clip(RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.gambar_electronik),
                        contentDescription = "teknisi",
                        modifier = Modifier.size(39.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp)
            ){
                Text(
                    text = "Service Alat Elektronik",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF2F2F31)
                    ),)
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "arrow next",
                    tint = Color(0xFF005695)
                )
            }
        }
    }
}

@Preview
@Composable
private fun JenisJasaScreenPrev() {
    JenisJasaScreen(modifier = Modifier, navController = rememberNavController())
}