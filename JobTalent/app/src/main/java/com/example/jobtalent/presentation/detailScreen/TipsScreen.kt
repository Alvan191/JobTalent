package com.example.jobtalent.presentation.detailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.TipsItem
import com.example.jobtalent.presentation.model.IsiTips

@Composable
fun TipsScreen(
    navController: NavController,
    tipsitem: List<IsiTips> = TipsItem.dataTips
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        Column (
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
                .background(
                    color = Color.White
                )
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
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
            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        color = Color(0xFFEDF7FF)
                    )
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Tips Membuat Portofolio yang\nSempurna",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),

                            )
                    )
                    Image(
                        painter = painterResource(id = R.drawable.tips_image),
                        contentDescription = "tips image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(73.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            LazyVerticalGrid(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp), columns = GridCells.Fixed(2),
//                modifier = modifier.fillMaxSize()
            ) {
                items(tipsitem, key = { it.id }) { listIsiTips ->
                    GridTips(
                        listIsiTips = listIsiTips
                    )
                }
            }
        }
    }
}

@Composable
fun GridTips(
    listIsiTips: IsiTips
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .zIndex(0f), // Card berada di bawah lingkaran
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 10.dp, top = 30.dp, end = 10.dp)
            ) {
                Text(
                    text = listIsiTips.descript,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000)
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, top = 5.dp, end = 5.dp)
                ) {
                    Box { }
                    Box (
                        modifier = Modifier
                            .offset(x = 20.dp, y = 25.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .offset(x = 16.dp, y = 30.dp)
                                .size(120.dp)
                                .clip(CircleShape)
                                .background(getBackgroundColor(listIsiTips.id))
                        )
                        Image(
                            painter = painterResource(id = listIsiTips.photo),
                            contentDescription = "tips",
                            modifier = Modifier
                                .offset(x = 50.dp, y = 0.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .size(width = 60.dp, height = 100.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .offset(x = (-8).dp, y = (-8).dp)
                .size(34.dp)
                .clip(CircleShape)
                .background(getBackgroundColor(listIsiTips.id))
                .align(Alignment.TopStart)
                .zIndex(1f)
        ) {
            Text(
                text = listIsiTips.name,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000)
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun getBackgroundColor(id: Int): Color {
    return when (id) {
        1 -> Color(0xFFFAF4CB)
        2 -> Color(0xFFEFFFCC)
        3 -> Color(0xFFE9F2FF)
        4 -> Color(0xFFF4E9FF)
        5 -> Color(0xFFFFEFF8)
        else -> Color(0xFFE0E0E0)
    }
}

@Preview
@Composable
private fun TipsScreenPreview() {
    TipsScreen(navController = rememberNavController())
}