package com.example.jobtalent.presentation.community.componentCommunity

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jobtalent.R

@Composable
fun ContentLazy(image: Int, name: String, time: String, desc_content: String, image_content: Int?, like: Int, comment: String, onClick: () -> Unit) {
    var isClicked by remember { mutableStateOf(false) }
    var likeCount by remember { mutableStateOf(like) }
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
                .wrapContentHeight()
                .background(
                    color = Color.White
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
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
                if (image_content != null) {
                    Image(
                        painter = painterResource(id = image_content),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(height = 180.dp)
                    )
                }
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
                            text = likeCount.toString(),
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
                        .padding(vertical = 10.dp, horizontal = 20.dp)
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
                                if (isClicked) {
                                    likeCount++
                                } else {
                                    likeCount--
                                }
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