package com.example.jobtalent.presentation

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
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(
                color = Color.White
            ),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.anto),
                contentDescription = "Anto Ramadhan",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(43.dp)
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
                        tint = Color(0xFF848484),) },
                placeholder = { Text(text = "Cari", color = Color(0xFF848484)) },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
                    .shadow(5.dp, RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = { navController.navigate(Screen.Postingdet.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3D4E79)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(50.dp)
            ) {
                Text(
                    text = "Post",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
                .background(
                    color = Color.White
                ),
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                ContentLazy(
                    image = R.drawable.image_satu,
                    name = "Saudara Bersama",
                    time = "24 Menit",
                    desc_content = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                    image_content = R.drawable.image_empat,
                    like = "500",
                    comment = "50 komentar",
                    onClick = { navController.navigate(Screen.Komentarsc.route) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                ContentLazy(
                    image = R.drawable.image_dua,
                    name = "Saudari Bersama",
                    time = "42 Menit",
                    desc_content = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                    image_content = R.drawable.image_lima,
                    like = "200",
                    comment = "15 komentar",
                    onClick = { navController.navigate(Screen.Komentarsc.route) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                ContentLazySec(
                    image = R.drawable.image_tiga,
                    name = "Saudaru Bersama",
                    time = "55 menit",
                    desc_content = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                    like = "110",
                    comment = "23 komentar",
                    onClick = { navController.navigate(Screen.Komentarsc.route) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                ContentLazy(
                    image = R.drawable.image_enam,
                    name = "Sodiri Bersama",
                    time = "1 jam",
                    desc_content = "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, ... pokoknya sangat recomended lah \uD83D\uDE2D\uD83D\uDE2D\uD83D\uDE23",
                    image_content = R.drawable.image_empat,
                    like = "430",
                    comment = "160 komentar",
                    onClick = { navController.navigate(Screen.Komentarsc.route) }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun ContentLazy(image: Int, name: String, time: String, desc_content: String, image_content: Int, like: String, comment: String, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }
    val iconColor = if (isClicked) Color(0xFF3F9AFA) else Color.Black

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
                            painter = painterResource(id = image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(45.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                text = name,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000)
                                )
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = time,
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
                        text = desc_content,
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
                        painter = painterResource(id = image_content),
                        contentDescription = null,
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
                                text = like,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(900),
                                    color = Color.Black
                                )
                            )
                            Text(
                                text = comment,
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
                            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
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
                                .clickable (onClick = onClick)
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

@Composable
fun ContentLazySec(image: Int, name: String, time: String, desc_content: String, like: String, comment: String, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }
    val iconColor = if (isClicked) Color(0xFF3F9AFA) else Color.Black

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
                            painter = painterResource(id = image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(45.dp)
                        )
                        Column(
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(
                                text = name,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_black)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF000000)
                                )
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = time,
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
                        text = desc_content,
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
                                text = like,
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_light)),
                                    fontWeight = FontWeight(900),
                                    color = Color.Black
                                )
                            )
                            Text(
                                text = comment,
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
                            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
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
                                .clickable (onClick = onClick)
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

@Preview
@Composable
private fun CommunityScreenPreview() {
    CommunityScreen(navController = rememberNavController())
}