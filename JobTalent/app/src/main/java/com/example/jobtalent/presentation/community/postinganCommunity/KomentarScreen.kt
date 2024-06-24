package com.example.jobtalent.presentation.community.postinganCommunity

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jobtalent.R
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.presentation.profile.model_view.SharedViewModel
import kotlinx.coroutines.launch

@Composable
fun KomentarScreen(
    navController: NavController
) {
    var messages by remember { mutableStateOf(listOf<Pair<String, Boolean>>()) }
    val scope = rememberCoroutineScope()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF8F8F8)
            ),
    ){
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .background(
                    color = Color(0xFFF8F8F8)
                ),
        ) {
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 2.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Back Icon",
                            tint = Color.Black,
                            modifier = Modifier
                                .background(Color(0xFFDFE9F1), CircleShape)
                                .size(40.dp)
                                .padding(8.dp)
                                .clickable { navController.popBackStack() }
                        )
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                CommentRow(
                    imageResource = R.drawable.sundari,
                    name = "Sundari",
                    time = "10 menit",
                    comment = "Semangat Para Ibu” 🔥🔥🔥"
                )
                CommentRow(
                    imageResource = R.drawable.ummy,
                    name = "Ummy",
                    time = "4 menit",
                    comment = "Bagus Banget 🔥🔥🔥"
                )
                CommentRow(
                    imageResource = R.drawable.muhammad,
                    name = "Pak Muh",
                    time = "1 menit",
                    comment = "Menyalah kakak ku🔥🔥🔥"
                )
                Isikomentar(messages = messages)
            }
            MessageInput(
                onMessageSent = { message ->
                    scope.launch {
                        messages = messages + Pair(message, true)
                    }
                },
                modifier = Modifier
                    .imePadding()
                    .fillMaxWidth()
                    .padding(bottom = 3.dp),
                sharedViewModel = SharedViewModel()
            )
        }
    }
}

@Composable
fun CommentRow(imageResource: Int, name: String, time: String, comment: String) {
    Spacer(modifier = Modifier.height(20.dp))
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Profile $name",
            modifier = Modifier
                .size(45.dp)
                .clip(shape = CircleShape)
        )
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 10.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "$name .",
                    color = Color(0xFF000000),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                )
                Text(
                    text = time,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff8d8d8d)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
            Text(
                text = comment,
                color = Color(0xFF000000),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
            )
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Isikomentar(messages: List<Pair<String, Boolean>>) {
    LazyColumn {
        items(messages.size) { index ->
            val message = messages[index]
            AnimatedVisibility(
                visible = true,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
                initiallyVisible = false
            ) {
                ChatBubble(message = message.first, isUserMe = message.second, sharedViewModel = SharedViewModel())
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInput(onMessageSent: (String) -> Unit, modifier: Modifier = Modifier, sharedViewModel: SharedViewModel) {
    var textState by remember { mutableStateOf(TextFieldValue()) }
    val imageUri by sharedViewModel.imageUri.observeAsState("")
    val painter = rememberAsyncImagePainter(
        imageUri.ifEmpty { R.drawable.person_profile }
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .padding(end = 8.dp)
                .clip(shape = CircleShape)
        )
        TextField(
            value = textState,
            onValueChange = { textState = it },
            placeholder = {
                Text(
                    text = "Berikan komentar",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        fontWeight = FontWeight(800),
                        color = Color(0xFF707070)
                    )
                )
            },
            textStyle = TextStyle(color = Color(0xFF000000)),
            modifier = Modifier
                .height(90.dp)
                .offset(y = 4.dp)
                .weight(1f),
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
fun ChatBubble(message: String, isUserMe: Boolean, sharedViewModel: SharedViewModel) {
    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val currentUserSec = sharedPreferencesManager.email?.substringBefore("@") ?: "N/A"

    val namaTampil = if (sharedPreferencesManager.name.isNullOrEmpty()) currentUserSec else sharedPreferencesManager.name

    val imageUri by sharedViewModel.imageUri.observeAsState("")
    val painter = rememberAsyncImagePainter(
        imageUri.ifEmpty { R.drawable.person_profile }
    )
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
    ){
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
                .clip(shape = CircleShape)
        )
        Column (
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 10.dp)
        ){
            Row (
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "$namaTampil.",
                    color = Color(0xFF000000),
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                )
                Text(
                    text = "baru saja",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xff8d8d8d)
                    ),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
            Text(
                text = message,
                color = Color(0xFF000000),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = if (isUserMe) TextAlign.End else TextAlign.Start,
                modifier = Modifier
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun KomentarPreview() {
    KomentarScreen(navController = rememberNavController())
}
