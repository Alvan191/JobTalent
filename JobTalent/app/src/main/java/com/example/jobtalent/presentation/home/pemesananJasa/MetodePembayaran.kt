package com.example.jobtalent.presentation.home.pemesananJasa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
fun MetodePembayaranScreen(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Box (
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable(onClick = { navController.popBackStack() })
            ){
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
            Text(
                text = "Metode Pembayaran",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Bank/ Virtual Account",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .clickable { navController.navigate(Screen.Paymentsum.route) }
                .requiredHeight(height = 60.dp)
                .shadow(5.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.White)
                .offset(x = 10.dp)
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
        ){
            Box (
                modifier = Modifier
                    .requiredSize(size = 35.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffd9e7f2))
                    .align(alignment = Alignment.CenterStart)
            ){

            }
            Image(
                painter = painterResource(id = R.drawable.logobank),
                contentDescription = "Logo Bank",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .requiredSize(20.dp)
                    .offset(x = 8.dp, y = 20.dp)
                    .background(Color(0xffd9e7f2), CircleShape)

            )
            Text(
                text = "Bank/ Virtual Account",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 50.dp, y = 0.dp),
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "E-Wallet",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp)
                .clickable { navController.navigate(Screen.Paymentsum.route) }
                .requiredHeight(height = 60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.White)
                .offset(x = 10.dp)
                .padding(horizontal = 10.dp)

        ){
            Box (
                modifier = Modifier
                    .requiredSize(size = 35.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffd9e7f2))
                    .align(alignment = Alignment.CenterStart)

            )
            Image(
                painter = painterResource(id = R.drawable.logodana),
                contentDescription = "Logo Dana",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .requiredSize(20.dp)
                    .offset(x = 8.dp, y = 20.dp)
                    .background(Color(0xffd9e7f2), CircleShape))
            Text(
                text = "Dana",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 50.dp, y = 0.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp))
        Box (
            modifier = Modifier
                .clickable { navController.navigate(Screen.Paymentsum.route) }
                .fillMaxWidth()
                .shadow(5.dp)
                .requiredHeight(height = 60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.White)
                .offset(x = 10.dp)
                .padding(horizontal = 10.dp)
        ){
            Box (
                modifier = Modifier
                    .requiredSize(size = 35.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffd9e7f2))
                    .align(alignment = Alignment.CenterStart)
            ){
            }
            Image(
                painter = painterResource(id = R.drawable.logogopay),
                contentDescription = "Logo gopay",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .requiredSize(20.dp)
                    .offset(x = 8.dp, y = 20.dp)
                    .background(Color(0xffd9e7f2), CircleShape)

            )
            Text(
                text = "Gopay",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 50.dp, y = 0.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(15.dp))
        Box (
            modifier = Modifier
                .clickable { navController.navigate(Screen.Paymentsum.route) }
                .fillMaxWidth()
                .shadow(5.dp)
                .requiredHeight(height = 60.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(color = Color.White)
                .offset(x = 10.dp)
                .padding(horizontal = 10.dp)
        ){
            Box (
                modifier = Modifier
                    .requiredSize(size = 35.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color(0xffd9e7f2))
                    .align(alignment = Alignment.CenterStart)
            ){
            }
            Image(
                painter = painterResource(id = R.drawable.logoovo),
                contentDescription = "Logo Dana",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .requiredSize(20.dp)
                    .offset(x = 8.dp, y = 20.dp)
                    .background(Color(0xffd9e7f2), CircleShape)

            )
            Text(
                text = "Ovo",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 50.dp, y = 0.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MetodePembayaranPreview() {
        MetodePembayaranScreen(navController = rememberNavController())
}