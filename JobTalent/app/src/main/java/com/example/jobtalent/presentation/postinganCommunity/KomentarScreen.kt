package com.example.jobtalent.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobtalent.R

@Composable
fun KomentarScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ){
            Box (
                modifier = Modifier.fillMaxWidth()
            ){
                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 2.dp)
                ){
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Back Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .background(Color(0xFFDFE9F1), CircleShape)
                            .size(40.dp)
                            .padding(8.dp)
                    )
                }
            }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Box (
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.sundari),
                    contentDescription = "Profile Sundari",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(45.dp)
                        .clip(shape = CircleShape)

                )
                Text(
                    text = "Sundari .",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 2.dp)
                )
                Text(
                    text = "10 menit",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff8d8d8d)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 115.dp, vertical = 4.dp)
                )
                Text(
                    text = "Semangat Para Ibu” 🔥🔥🔥",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 25.dp)
                )
            }
        }
        Row {
            Box (
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.ummy),
                    contentDescription = "Profile ummy",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(45.dp)
                        .clip(shape = CircleShape)

                )
                Text(
                    text = "Ummy .",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 2.dp)
                )
                Text(
                    text = "4 menit",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff8d8d8d)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 115.dp, vertical = 4.dp)
                )
                Text(
                    text = "Bagus Banget 🔥🔥🔥",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 25.dp)
                )
            }
        }
        Row {
            Box (
                modifier = Modifier.fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = R.drawable.muhammad),
                    contentDescription = "Profile muhammad",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(45.dp)
                        .clip(shape = CircleShape)

                )
                Text(
                    text = "Muhammad .",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 2.dp)
                )
                Text(
                    text = "1 menit",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff8d8d8d)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 145.dp, vertical = 4.dp)
                )
                Text(
                    text = "Menyalah kakak ku🔥🔥🔥",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    modifier = Modifier
                        .padding(horizontal = 55.dp, vertical = 25.dp)
                )
            }
        }

        Spacer(modifier = Modifier.padding(60.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(height = 100.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color(0xffDCE3E9))
        )
        {
            Image(
                painter = painterResource(id = R.drawable.antobulat),
                contentDescription = "Profile Anto",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(
                        x = 6.dp,
                        y = 9.dp
                    )
                    .requiredSize(size = 45.dp)
                    .clip(shape = CircleShape)
            )
            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 52.dp, y = 4.dp)
                    .requiredHeight(height = 99.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Berikan komentar",
                        style = TextStyle(
                            fontSize = 14.sp,
//                            fontFamily = FontFamily(Font(R.font.roboto)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFFBEBEBE),
                        )
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            color = Color(0xffd7d7d7).copy(alpha = 0.78f),
            modifier = Modifier
                .requiredWidth(width = 360.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.logogif),
                contentDescription = "Logo Gif",
                modifier = Modifier
                    .width(30.dp)
                    .height(24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logoaddphoto),
                contentDescription = "Logo Add Photo",
                modifier = Modifier
                    .width(35.dp)
                    .height(29.dp)
                    .offset(x = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logoloc),
                contentDescription = "Logo Location",
                modifier = Modifier
                    .width(30.dp)
                    .height(24.dp)
                    .offset(x = 15.dp)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KomentarPreview() {
        KomentarScreen()
}