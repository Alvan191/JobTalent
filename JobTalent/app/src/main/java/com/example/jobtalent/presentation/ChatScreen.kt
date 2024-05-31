package com.example.jobtalent.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import com.example.jobtalent.data.ChatItem
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.model.IsiChat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    modifier: Modifier,
    navController: NavController,
    chat: List<IsiChat> = ChatItem.dataChat
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        TopAppBar(
            modifier = Modifier
                .background(
                    color = Color.White),
            title = {
                Text(
                    text = "Pesan",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    )
                )
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Search, // Replace with your search icon resource
                        contentDescription = "Search",
                        tint = Color.Black
                    )
                }
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            items(chat, key = { it.id }) { tampilchat ->
                ItemChat(
                    modifier = modifier,
                    tampilchat = tampilchat,
                    onClick = { navController.navigate(Screen.DetailChatsss.route + "/${tampilchat.id}") }
                )
            }
        }
    }
}

@Composable
fun ItemChat(
    modifier: Modifier,
    tampilchat: IsiChat,
    onClick: () -> Unit
) {
    Card (
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .height(height = 70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(1.dp)
    ){
        Box(
            modifier
                .padding(10.dp)
        ){
            Row (){
                Image(
                    painter = painterResource(id = tampilchat.photo),
                    contentDescription = tampilchat.name,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(13.dp))
                Column (
                    modifier = Modifier.align(Alignment.CenterVertically)
                ){
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                    ){
                        Text(
                            text = tampilchat.name,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = tampilchat.waktu,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_light)),
                                fontWeight = FontWeight(300),
                                color = Color(0xFF000000)
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = tampilchat.descript,
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        fontSize = 12.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFF979797),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ChatScreenPrev() {
    ChatScreen(modifier = Modifier, navController = rememberNavController())
}