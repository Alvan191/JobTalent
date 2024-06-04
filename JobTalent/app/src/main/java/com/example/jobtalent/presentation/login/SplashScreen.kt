package com.example.jobtalent.login

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun SplashScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF005695))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 50.dp, end = 15.dp),
        ) {
            Text(
                text = "Temukan Pekerjaanmu \nHari ini!",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),

                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Ingin mencari pekerjaan tetapi tidak sesuai minat kamu? Ayo cari pekerjaanmu di sini!",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF)
                    )
            )
        }
        Spacer(modifier = Modifier.height(23.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_car4),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(475.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(35.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) { Box{}
            Image(
                painter = painterResource(id = R.drawable.loader),
                contentDescription = null,
                modifier = Modifier
                    .clickable(onClick = {navController.navigate(Screen.Login.route)})
                    .clip(CircleShape)
                    .size(70.dp),
                contentScale = ContentScale.Crop,)
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(navController = rememberNavController())
}
