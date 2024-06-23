package com.example.jobtalent.presentation.home.pemesananJasa.component

import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriMC
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriBrandIdentity
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriDecorator
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriGraphicDesigner
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriIllustrator
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriStageManager

@Composable
fun <katGraphicDesigner : KategoriGraphicDesigner> GraphicDesignerColumnItem(item: katGraphicDesigner, navController: NavController) {
    Card (
        modifier = Modifier
            .clickable { navController.navigate(Screen.DetJasa.route) }
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
                text = "Rp. 50.000 - 400.000",
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
                        .width(80.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Poster",
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
                        .width(80.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Brosur",
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
                        .width(80.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Iklan",
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
fun <katIllustrator : KategoriIllustrator> IllustratorColumnItem(item: katIllustrator, navController: NavController) {
    Card (
        modifier = Modifier
            .clickable { navController.navigate(Screen.DetJasa.route) }
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
                text = "Rp. 100.000 - 800.000",
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
                        text = "Majalah",
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
                        text = "Produk",
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
                        .width(80.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Media Digital",
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
fun <katBrandIdentity : KategoriBrandIdentity> BrandIdentityColumnItem(item: katBrandIdentity, navController: NavController) {
    Card (
        modifier = Modifier
            .clickable { navController.navigate(Screen.DetJasa.route) }
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
                        text = "Logo",
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
                        text = "Typographic",
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
                        .width(80.dp)
                        .height(24.dp)
                        .background(
                            color = Color(0xFFD8EDFF),
                            shape = RoundedCornerShape(4.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Pallet Color",
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