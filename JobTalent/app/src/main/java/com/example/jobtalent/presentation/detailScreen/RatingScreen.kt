package com.example.jobtalent.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.text.BasicTextField
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RatingJasa(
    navController: NavController
) {
    var selectedRating by remember { mutableStateOf(0) }
    var reviewText by remember { mutableStateOf(TextFieldValue("")) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(color = Color.White)
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Box (
                modifier = Modifier
                    .size(45.dp)
                    .shadow(8.dp, CircleShape)
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
                text = "Beri Penilaian",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xff000000)),
                modifier = Modifier.padding(start = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Ketuk untuk menilai",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.height(25.dp))

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .requiredHeight(50.dp)

        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                for (i in 1..5) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star Icon",
                        tint = if (i <= selectedRating) Color(0xffffd700) else Color(0xff717171),
                        modifier = Modifier
                            .size(50.dp)
                            .clickable { selectedRating = i }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Tulis ulasan",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.W500,
                color = Color(0xFF000000)),
        )

        Spacer(modifier = Modifier.height(15.dp))
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(108.dp)
                .clip(shape = RoundedCornerShape(5.dp))
                .background(Color.White)
                .border(
                    border = BorderStroke(1.dp, Color(0xffb2b2b2)),
                    shape = RoundedCornerShape(5.dp)
                )
        ){
            BasicTextField(
                value = reviewText,
                onValueChange = { reviewText = it },
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W300,
                    color = Color(0xFF000000)
                ),
                modifier = Modifier
                    .padding(17.dp)
                    .fillMaxSize()
            ) { innerTextField ->
                if (reviewText.text.isEmpty()) {
                    Text(
                        text = "Masukkan tanggapan Anda disini",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W300,
                            color = Color(0x96717171)),
                    )
                }
                innerTextField()
            }
        }
        Spacer(modifier = Modifier.height(350.dp))
        Button(
            onClick = { navController.popBackStack() },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff0060a5)),
            contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 50.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(height = 50.dp)
            ) {
                Text(
                    text = "Kirim Ulasan",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RatingJasaPreview() {
    RatingJasa(navController = rememberNavController())
}