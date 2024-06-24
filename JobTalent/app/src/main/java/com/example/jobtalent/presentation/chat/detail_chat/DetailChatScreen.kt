package com.example.jobtalent.presentation.chat.detail_chat


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.jobtalent.R
import com.example.jobtalent.data.item.ChatItem
import com.example.jobtalent.presentation.model.IsiChat
import kotlinx.coroutines.launch


@Composable
fun DetailChatScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    tampilchatId: Int?
) {
    var messages by remember { mutableStateOf(listOf<Pair<String, Boolean>>()) }
    val scope = rememberCoroutineScope()

    val newChatList = ChatItem.dataChat.filter { tampilchat ->
        tampilchat.id == tampilchatId
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE4E4E4))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(15.dp)
        ) {
            HeaderChat(newChatList, navController)
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White))
            DetailChat(messages = messages)
        }

        MessageInputt(
            onMessageSent = { message ->
                scope.launch {
                    messages = messages + Pair(message, true)
                    keyboardController?.hide()
                }
            },
            modifier = Modifier
                .imePadding()
                .fillMaxWidth()
                .padding(bottom = 3.dp)
        )
    }
}


@Composable
fun HeaderChat(
    newChatList: List<IsiChat>,
    navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
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
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun DetailChat(messages: List<Pair<String, Boolean>>) {
    LazyColumn(
        modifier = Modifier.wrapContentSize()
    ) {
        item {
            ContentChat()
        }
        items(messages.size) { index ->
            val message = messages[index]
            AnimatedVisibility(
                visible = true,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
                initiallyVisible = false
            ) {
                ChatBubblee(message = message.first, isUserMe = message.second)
            }
        }
    }
}

@Composable
fun ContentChat() {
    val customShape_two = RoundedCornerShape(
        topStart = CornerSize(16.dp),
        topEnd = CornerSize(16.dp),
        bottomStart = CornerSize(0.dp),
        bottomEnd = CornerSize(16.dp)
    )

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
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
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(width = 300.dp, height = 80.dp)
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
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInputt(onMessageSent: (String) -> Unit, modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        TextField(
            value = textState,
            onValueChange = { textState = it },
            placeholder = { Text(text = "Ketik Pesan", color = Color(0xFF707070),) },
            textStyle = TextStyle(color = Color(0xFF000000)),
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xE8F3F3F3),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        IconButton(
            onClick = {
                if (textState.text.isNotBlank()) {
                    onMessageSent(textState.text)
                    textState = TextFieldValue()
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

@Composable
fun ChatBubblee(
    message: String,
    isUserMe: Boolean
) {
    val bubbleColor = if (isUserMe) Color(0xFF005695) else Color.White
    val textColor = if (isUserMe) Color.White else Color.Black
    val bubbleShape = if (isUserMe) {
        RoundedCornerShape(
            topStart = CornerSize(16.dp),
            topEnd = CornerSize(16.dp),
            bottomStart = CornerSize(16.dp),
            bottomEnd = CornerSize(0.dp)
        )
    } else {
        RoundedCornerShape(
            topStart = CornerSize(16.dp),
            topEnd = CornerSize(16.dp),
            bottomStart = CornerSize(0.dp),
            bottomEnd = CornerSize(16.dp)
        )
    }

    Row (
        horizontalArrangement = if (isUserMe) Arrangement.End else Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = if (isUserMe) Alignment.TopEnd else Alignment.TopStart
        ) {
            Text(
                text = message,
                color = textColor,
                modifier = Modifier
                    .background(bubbleColor, shape = bubbleShape)
                    .padding(12.dp),
                fontSize = 16.sp,
                textAlign = if (isUserMe) TextAlign.End else TextAlign.Start
            )
        }
    }
}

