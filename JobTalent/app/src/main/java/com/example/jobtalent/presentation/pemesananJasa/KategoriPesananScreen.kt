package com.example.jobtalent.presentation.pemesananJasa

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
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
import com.example.jobtalent.data.KatPesananItem
import com.example.jobtalent.presentation.model.KategoriKerja
import com.example.jobtalent.presentation.model.KategoriPemangkas
import com.example.jobtalent.presentation.model.KategoriPenjahit
import com.example.jobtalent.presentation.model.KategoriServis

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KategoriPesananScreen(
    navController: NavController,
    kategoriPenjahit: List<KategoriPenjahit> = KatPesananItem.dataPenjahit,
    kategoriPemangkas: List<KategoriPemangkas> = KatPesananItem.dataPemangkas,
    kategoriServis: List<KategoriServis> = KatPesananItem.dataServis
) {
    var selectedCategory by remember { mutableStateOf("Semua") }
    val categories = listOf("Semua", "Penjahit", "Pemangkas Rambut", "Servis Elektronik")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(color = Color.White)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Box(
                modifier = Modifier
                    .size(45.dp)
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
                    .shadow(8.dp, RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp)),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            ) 
        }
        Spacer(modifier = Modifier.height(10.dp))
        
        TopNavigationBar(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )

        LazyColumn (
            modifier = Modifier.fillMaxSize()
        ){
            val itemsToShow = when (selectedCategory) {
                "Penjahit" -> kategoriPenjahit
                "Pemangkas Rambut" -> kategoriPemangkas
                "Servis Elektronik" -> kategoriServis
                else -> listOf<KategoriKerja>() + kategoriPenjahit + kategoriPemangkas + kategoriServis
            }
            items(itemsToShow) { item ->
                when (item) {
                    is KategoriPenjahit -> ColumnItem(item)
                    is KategoriPemangkas -> PemangkasColumnItem(item)
                    is KategoriServis -> ServisColumnItem(item)
                }
            }
        }
    }
}

@Composable
fun <katJahit : KategoriPenjahit> ColumnItem(item: katJahit) {
    Card (
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Column(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth()
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = item.photo),
                    contentDescription = item.name,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(50.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = item.talent,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF818181),

                                )
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "5,0",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(750),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Rp. 100.000 - 2.000.000",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Permak",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Desain",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Kebaya",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun <katPangkas : KategoriPemangkas> PemangkasColumnItem(item: katPangkas) {
    Card (
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Column(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth()
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = item.photo),
                    contentDescription = item.name,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(50.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = item.talent,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF818181),

                                )
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "5,0",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(750),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Rp. 20.000 - 70.000",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mulet",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mohawk",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Two Block",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun <katServis : KategoriServis> ServisColumnItem(item: katServis) {
    Card (
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Column(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth()
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Image(
                    painter = painterResource(id = item.photo),
                    contentDescription = item.name,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(50.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(10.dp))
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = item.name,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = item.talent,
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF818181),

                                )
                        )
                    }
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                    ){
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star",
                            tint = Color(0xFFFFC107),
                            modifier = Modifier
                                .size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "5,0",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(750),
                                color = Color(0xFF000000),
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Rp. 20.000 - 70.000",
                style = TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(300),
                    color = Color(0xFF000000)
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Kulkas",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "AC",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "TV",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 14.4.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF276093)
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TopNavigationBar(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            val backgroundColor = if (isSelected) Color(0xFF0060A5) else Color(0xFFEEEEEE)
            val textColor = if (isSelected) Color.White else Color.Black

            Text(
                text = category,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(backgroundColor)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .clickable { onCategorySelected(category) },
                color = textColor,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview
@Composable
private fun KategoriPesananScreenPrev() {
    KategoriPesananScreen(navController = rememberNavController())
}