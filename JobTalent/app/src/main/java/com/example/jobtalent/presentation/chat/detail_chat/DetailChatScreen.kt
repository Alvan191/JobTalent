package com.example.jobtalent.presentation.chat.detail_chat


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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jobtalent.R
import com.example.jobtalent.data.ChatItem
import com.example.jobtalent.presentation.model.IsiChat
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailChatScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    tampilchatId: Int?
) {

    val newChatList = ChatItem.dataChat.filter { tampilchat ->
        tampilchat.id == tampilchatId
    }
    Column(
        modifier = modifier
    ) {
        DetailChat(newChatList, modifier, navController)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailChat(
    newChatList: List<IsiChat>,
    modifier: Modifier,
    navController: NavController,
) {
    val (messageText, setMessageText) = remember { mutableStateOf("") }
    val coroutineScope = rememberCoroutineScope()
    val customShape_one = RoundedCornerShape(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp),
        bottomStart = CornerSize(16.dp),
        bottomEnd = CornerSize(0.dp)
    )

    val customShape_two = RoundedCornerShape(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp),
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(16.dp)
    )

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFEBEBEB)
            )
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 15.dp, end = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
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
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(data = newChatList[0].photo)
                            .build(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(37.dp),
                        contentDescription = "Image Profil"
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "${newChatList[0].name}",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFF000000)
                        )
                    )
                }
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Lainnya"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 2.dp)
                    .background(
                        color = Color(0xFFD8D8D8)
                    )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(40.dp)
                    .padding(8.dp)
                    .border(1.dp, Color(0xFFC2C2C2), RoundedCornerShape(10.dp))
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 90.dp, height = 39.dp)
                        .background(Color.White, RoundedCornerShape(15.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Hari Ini",
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Box { }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "12.56",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFFB2B2B2),

                            )
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 300.dp, height = 100.dp)
                            .clip(customShape_one)
                            .background(Color(0xFF005695))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Selamat siang, perkenalkan saya Anto. Saya sangat suka dengan portofolio anda",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 300.dp, height = 100.dp)
                            .clip(customShape_two)
                            .background(Color(0xFFFFFFFF))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Selamat siang pak Anto, terimakasih sudah menyempatkan waktu untuk melihat porto saya",
                            color = Color.Black,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "13.00",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFFB2B2B2)
                        )
                    )
                }
                Box { }
            }

            Spacer(modifier = Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Box { }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "12.56",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(300),
                            color = Color(0xFFB2B2B2),

                            )
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 300.dp, height = 100.dp)
                            .clip(customShape_one)
                            .background(Color(0xFF005695))
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Pekerjaanmu sangat luar biasa, saya tertarik mengajak kamu dalam proyek kerja saya ",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            TextField(
                value = messageText,
                onValueChange = setMessageText,
                placeholder = { Text(text = "Ketik Pesan") },
                modifier = Modifier.weight(1f),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xE8F3F3F3),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        setMessageText("")
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = Color(0xFF005695)
                )
            }
        }
    }
}