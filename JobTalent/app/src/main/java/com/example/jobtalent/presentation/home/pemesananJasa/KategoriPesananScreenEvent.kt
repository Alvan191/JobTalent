package com.example.jobtalent.presentation.home.pemesananJasa

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.data.item.KatPesananItemEvent
import com.example.jobtalent.presentation.home.pemesananJasa.component.DecoratorColumnItem
import com.example.jobtalent.presentation.home.pemesananJasa.component.MCColumnItem
import com.example.jobtalent.presentation.home.pemesananJasa.component.StageManagerColumnItem
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriDecorator
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriMC
import com.example.jobtalent.presentation.model.kategoripenyedia.KategoriStageManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KategoriPesananEventScreen(
    navController: NavController,
    kategoriMC: List<KategoriMC> = KatPesananItemEvent.dataMC,
    kategoriDecorator: List<KategoriDecorator> = KatPesananItemEvent.dataDecorator,
    kategoriStageManager: List<KategoriStageManager> = KatPesananItemEvent.dataStageManager
) {
    var selectedCategory by remember { mutableStateOf("Semua") }
    var searchText by remember { mutableStateOf("") }
    val categories = listOf("Semua", "MC", "Decorator", "Stage Manager")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(color = Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
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

        TopNavigationBarEvent(
            categories = categories,
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            val filteredItemsToShow = when (selectedCategory) {
                "MC" -> kategoriMC.filter { it.name.contains(searchText, ignoreCase = true) }
                "Decorator" -> kategoriDecorator.filter { it.name.contains(searchText, ignoreCase = true) }
                "Stage Manager" -> kategoriStageManager.filter { it.name.contains(searchText, ignoreCase = true) }
                else -> (kategoriMC.filter { it.name.contains(searchText, ignoreCase = true) } +
                        kategoriDecorator.filter { it.name.contains(searchText, ignoreCase = true) } +
                        kategoriStageManager.filter { it.name.contains(searchText, ignoreCase = true) })
            }
            items(filteredItemsToShow) { item ->
                when (item) {
                    is KategoriMC -> MCColumnItem(item, navController)
                    is KategoriDecorator -> DecoratorColumnItem(item, navController)
                    is KategoriStageManager -> StageManagerColumnItem(item, navController)
                }
            }
        }
    }
}

@Composable
fun TopNavigationBarEvent(
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
private fun KategoriPesananScreenEventPrev() {
    KategoriPesananEventScreen(navController = rememberNavController())
}