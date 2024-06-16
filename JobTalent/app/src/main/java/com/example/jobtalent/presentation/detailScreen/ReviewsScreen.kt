package com.example.jobtalent.presentation.detailScreen

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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


@Composable
fun ReviewsScreen(navController: NavController) {
    val selectedFilter = remember { mutableStateOf("Semua") }
    var filteredReviews = remember { mutableStateOf(reviews) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
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
                        .size(20.dp)
                        .align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${selectedFilter.value} (${filteredReviews.value.size} ulasan)",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000)
                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        RatingFilterRow(
            selectedFilter = selectedFilter,
            onFilterChange = {
                filterReviews(it, filteredReviews)
                selectedFilter.value = it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn {
            items(filteredReviews.value.size) { index ->
                ReviewItem(filteredReviews.value[index])
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

@Composable
fun ReviewItem(review: Review) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = review.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFC107),
                    modifier = Modifier
                        .size(18.dp)
                )
                Text(
                    text = review.rating.toString(),
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_light)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = review.comment,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(700),
                color = Color.Black,
            )
        )
    }
}

@Composable
fun RatingFilterRow(selectedFilter: MutableState<String>, onFilterChange: (String) -> Unit) {
    val filters = listOf("Semua", "5", "4", "3", "2", "1")

    LazyRow (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        items(filters) { filter ->
            FilterButton(
                text = filter,
                isSelected = selectedFilter.value == filter,
                onClick = {
                    onFilterChange(filter)
                }
            )
        }
    }
}

@Composable
fun FilterButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color.White else Color.Black
    val buttonColor = if (isSelected) Color(0xFF005695) else Color(0xFFEEEEEE)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor
        ),
        modifier = Modifier
            .padding(horizontal = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isSelected) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color(0xFFFFC107),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),
                    color = backgroundColor
                )
            )
        }
    }
}

fun filterReviews(rating: String, filteredReviews: MutableState<List<Review>>) {
    filteredReviews.value = if (rating == "Semua") {
        reviews
    } else {
        val filterRating = rating.toDoubleOrNull() ?: 0.0
        reviews.filter { it.rating == filterRating }
    }
}

data class Review(val name: String, val comment: String, val rating: Double)

val reviews = listOf(
    Review("Anisa Sidqia", "Hasil jahitannya sangat rapi dan sesuai dengan permintaan saya.", 5.0),
    Review("Aisyah Kinanti", "Harga terjangkau dengan kualitas yang luar biasa. Sangat puas dengan hasil akhirnya", 5.0),
    Review("Kinara Putri", "Sangat merekomendasikan jasa Pak Anto! Pekerjaannya selalu tepat waktu dan sesuai harapan", 5.0),
    Review("Adam Iskandar", "Penjahit terbaik yang pernah saya coba, detailnya sangat diperhatikan.", 5.0),
    Review("Ridho Kurnia", "Wahhhh penjahitnya hebat bangettt... baju saya yang longgar di buat pas dengan ukuran badan saya, dan jahitannya rapi banget, lain kali jahit baju disini aja dehh ehehhe", 4.0),
    Review("Selena Roro", "Wahhh baru kali ini dapat penjahit yang bertalenta, gesit, ramah, kreatif, pokoknya sangat recomended lah", 5.0)
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReviewsScreen(navController = rememberNavController())
}