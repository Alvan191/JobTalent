package com.example.jobtalent.presentation.modeJasa

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.data.KategoriJasaItem
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.model.KategoriJasa

@Composable
fun KategoriJasaScreen(
    modifier : Modifier,
    navController: NavController,
    kategorijasa : List<KategoriJasa> = KategoriJasaItem.dataKategoriJasa
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.White
            )
    ){
        Column(
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
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Daftar Penyedia Jasa",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_black)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF000000)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Apa ketegori jasa yang ingin Anda tawarkan",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF717171),
                    )
                )
            }

            LazyVerticalGrid(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp), columns = GridCells.Fixed(2),
                modifier = modifier.fillMaxSize()
            ) {
                items(kategorijasa, key = { it.id }) { kategorijasadaftar ->
                    GridScItem(
                        kategorijasadaftar = kategorijasadaftar,
                        onClick = { navController.navigate(route = Screen.JenisJasa.route) }
                    )
                }
            }
        }
    }
}

@Composable
fun GridScItem(
    kategorijasadaftar: KategoriJasa,
    onClick: () -> Unit
) { Card (
    modifier = Modifier
        .padding(8.dp)
        .clickable(onClick = onClick)
        .fillMaxWidth()
        .wrapContentHeight(),
    colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
    elevation = CardDefaults.cardElevation(10.dp)
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(150.dp, 85.dp)
                .background(Color(0xFF7FD5FC))
                .clip(RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = kategorijasadaftar.photo),
                contentDescription = kategorijasadaftar.name,
                modifier = Modifier.size(55.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF005695))
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = kategorijasadaftar.name,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}
}



@Preview
@Composable
private fun KategoriJasaPreview() {
    KategoriJasaScreen(modifier = Modifier, navController = rememberNavController())
}