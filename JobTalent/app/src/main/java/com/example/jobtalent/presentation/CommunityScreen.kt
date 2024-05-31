package com.example.jobtalent.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
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
import com.example.jobtalent.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(
    modifier: Modifier
) {
    var isClicked by remember { mutableStateOf(false) }
    var isClicked_second by remember { mutableStateOf(false) }
    var isClicked_third by remember { mutableStateOf(false) }
    var isClicked_fourth by remember { mutableStateOf(false) }

    val iconColor = if (isClicked) Color(0xFF3F9AFA) else Color.Black
    val iconColor_second = if (isClicked_second) Color(0xFF3F9AFA) else Color.Black
    val iconColor_third = if (isClicked_third) Color(0xFF3F9AFA) else Color.Black
    val iconColor_fourth = if (isClicked_fourth) Color(0xFF3F9AFA) else Color.Black


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            ),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.anto),
                    contentDescription = "Anto Ramadhan",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(45.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
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
                    placeholder = { Text(text = "Cari", color = Color(0xFF848484)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .shadow(5.dp, RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(height = 360.dp)
                        .background(
                            color = Color.White
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_satu),
                                contentDescription = "image satu",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(50.dp)
                            )
                            Column(
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "Sodara Bersama",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "24 menit",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 17.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF575757),
                                textAlign = TextAlign.Justify,
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.image_empat),
                            contentDescription = "image empat",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 180.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(23.dp)
                                    .background(
                                        color = Color(0xFF34B4F0),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ThumbUp,
                                    contentDescription = "Thumb Up",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(13.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "500",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = "50 komentar",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                        Box(
                            Modifier
                                .padding(6.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(color = Color(0xFFF4F4F4))
                        )
                        Row(
                            modifier = Modifier
                                .padding(top= 10.dp, start = 20.dp, end = 20.dp)
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Thumb Up",
                                tint = iconColor,
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        isClicked = !isClicked
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.Comment,
                                contentDescription = "Comment",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(height = 360.dp)
                        .background(
                            color = Color.White
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_dua),
                                contentDescription = "image dua",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(50.dp)
                            )
                            Column(
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "Saudari Bersama",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "42 menit",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 17.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF575757),
                                textAlign = TextAlign.Justify,
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.image_lima),
                            contentDescription = "image lima",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 180.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(23.dp)
                                    .background(
                                        color = Color(0xFF34B4F0),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ThumbUp,
                                    contentDescription = "Thumb Up",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(13.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "200",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = "15 komentar",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                        Box(
                            Modifier
                                .padding(6.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(color = Color(0xFFF4F4F4))
                        )
                        Row(
                            modifier = Modifier
                                .padding(top= 10.dp, start = 20.dp, end = 20.dp)
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Thumb Up",
                                tint = iconColor_second,
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        isClicked_second = !isClicked_second
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.Comment,
                                contentDescription = "Comment",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(height = 180.dp)
                        .background(
                            color = Color.White
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_tiga),
                                contentDescription = "image tiga",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(50.dp)
                            )
                            Column(
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "Saudaru Bersama",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "55 menit",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 17.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF575757),
                                textAlign = TextAlign.Justify,
                            )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(23.dp)
                                    .background(
                                        color = Color(0xFF34B4F0),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ThumbUp,
                                    contentDescription = "Thumb Up",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(13.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "110",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = "23 komentar",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                        Box(
                            Modifier
                                .padding(6.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(color = Color(0xFFF4F4F4))
                        )
                        Row(
                            modifier = Modifier
                                .padding(top= 10.dp, start = 20.dp, end = 20.dp)
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Thumb Up",
                                tint = iconColor_third,
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        isClicked_third = !isClicked_third
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.Comment,
                                contentDescription = "Comment",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(height = 360.dp)
                        .background(
                            color = Color.White
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.image_enam),
                                contentDescription = "image enam",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .size(50.dp)
                            )
                            Column(
                                modifier = Modifier.padding(start = 8.dp)
                            ) {
                                Text(
                                    text = "Sodiri Bersama",
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                                        fontWeight = FontWeight(500),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "1 jam",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                            style = TextStyle(
                                fontSize = 12.sp,
                                lineHeight = 17.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFF575757),
                                textAlign = TextAlign.Justify,
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.image_empat),
                            contentDescription = "image empat",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(height = 180.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(23.dp)
                                    .background(
                                        color = Color(0xFF34B4F0),
                                        shape = CircleShape
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ThumbUp,
                                    contentDescription = "Thumb Up",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(13.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "430",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                                Text(
                                    text = "160 komentar",
                                    style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                                        fontWeight = FontWeight(900),
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                        Box(
                            Modifier
                                .padding(6.dp)
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(color = Color(0xFFF4F4F4))
                        )
                        Row(
                            modifier = Modifier
                                .padding(top= 10.dp, start = 20.dp, end = 20.dp)
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                imageVector = Icons.Default.ThumbUp,
                                contentDescription = "Thumb Up",
                                tint = iconColor_fourth,
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        isClicked_fourth = !isClicked_fourth
                                    }
                            )
                            Icon(
                                imageVector = Icons.Default.Comment,
                                contentDescription = "Comment",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                            Icon(
                                imageVector = Icons.Default.Share,
                                contentDescription = "Share",
                                tint = Color.Black,
                                modifier = Modifier
                                    .size(22.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CommunityScreenPreview() {
    CommunityScreen(modifier = Modifier)
}