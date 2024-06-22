package com.example.jobtalent.presentation.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.community.componentCommunity.ContentLazy
import com.example.jobtalent.presentation.community.componentCommunity.posts
import com.example.jobtalent.presentation.profile.model_view.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel
) {
    val imageUri by sharedViewModel.imageUri.observeAsState("")
    val painter = rememberAsyncImagePainter(
        imageUri.ifEmpty { R.drawable.person_profile }
    )

    var searchText by remember { mutableStateOf("") }

    val filteredPosts = if (searchText.isEmpty()) posts else posts.filter { it.name.contains(searchText, ignoreCase = true) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .background(
                color = Color(0xFFF8F8F8)
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
                painter = painter,
                contentDescription = "Anto Ramadhan",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(43.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
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
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005695)),
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
                .padding(bottom = 5.dp)
                .background(
                    color = Color(0xFFF8F8F8)
                ),
        ) {
            items(filteredPosts.size) { index ->
                val post = filteredPosts[index]
                Spacer(modifier = Modifier.height(8.dp))
                ContentLazy(
                    image = post.image,
                    name = post.name,
                    time = post.time,
                    desc_content = post.desc_content,
                    image_content = post.image_content,
                    like = post.like.toInt(),
                    comment = post.comment,
                    onClick = { navController.navigate(Screen.Komentarsc.route) }
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCommunityScreen() {
    CommunityScreen(
        navController = rememberNavController(),
        sharedViewModel = SharedViewModel()
    )
}
