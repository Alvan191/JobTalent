package com.example.jobtalent.presentation.profile

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
import coil.compose.rememberAsyncImagePainter
import com.example.jobtalent.R
import com.example.jobtalent.data.sharedpreference.SharedPreferencesManager
import com.example.jobtalent.navigation.Screen
import com.example.jobtalent.presentation.profile.model_view.SharedViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier,
    sharedViewModel: SharedViewModel
) {
    val context = LocalContext.current
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val currentUser = sharedPreferencesManager.email ?: "N/A"
    val currentUserSec = sharedPreferencesManager.email?.substringBefore("@") ?: "N/A"

    val namaTampil = if (sharedPreferencesManager.name.isNullOrEmpty()) currentUserSec else sharedPreferencesManager.name

    val imageUri by sharedViewModel.imageUri.observeAsState("")
    val painter = rememberAsyncImagePainter(
        imageUri.ifEmpty { R.drawable.person_profile }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF8F8F8)
            ),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 325.dp)
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF005695),
                                Color(0xFF87CEEB)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                        )
                    )
                    .shadow(
                        elevation = 4.dp,
                        spotColor = Color(0x1A000000),
                        ambientColor = Color(0x1A000000)
                    )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Profile",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 15.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(130.dp)
                            .clip(CircleShape)
                            .border(4.dp, Color.White, CircleShape)
                            .clickable(onClick = { navController.navigate(Screen.Portofolios.route) })
                    )
                    Text(
                        text = "$namaTampil",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                    Text(
                        text = "$currentUser",
                        style = TextStyle(
                            fontSize = 13.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_black)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF)
                        ),
                        modifier = Modifier
                            .padding(top = 10.dp)
                    )
                }
            }
        }


        Card(
            modifier = Modifier
                .size(width = 325.dp, height = 550.dp)
                .padding(top = 180.dp)
                .align(Alignment.Center)
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .zIndex(1f),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
            ) {
                RowProItem(
                    icon = Icons.Default.Person,
                    label = "Akun Saya",
                    iconSec = Icons.Default.NavigateNext,
                    onClick = {navController.navigate(Screen.Accountsc.route)}
                )
                Spacer(modifier = Modifier.height(26.dp))
                RowProItem(
                    icon = Icons.Default.Settings,
                    label = "Pengaturan",
                    iconSec = Icons.Default.NavigateNext,
                    onClick = {navController.navigate(Screen.Settingss.route)}
                )
                Spacer(modifier = Modifier.height(26.dp))
                RowProItem(
                    icon = Icons.Default.Phone,
                    label = "Hubungi",
                    iconSec = Icons.Default.NavigateNext,
                    onClick = {navController.navigate(Screen.PusatBantu.route) }
                )

                Spacer(modifier = Modifier.height(135.dp))
                Button(
                    onClick = { navController.navigate(Screen.KategoriJasa.route) },
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 19.dp)
                        .background(
                            color = Color(0xFF005695),
                            shape = RoundedCornerShape(size = 10.dp)
                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF005695)
                    ),
                    ) {
                    Text(
                        text = "Mode Penyedia Jasa",
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        fontWeight = FontWeight(650),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Composable
fun RowProItem(icon: ImageVector, label: String, iconSec: ImageVector, onClick: () -> Unit) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF005695),
            modifier = Modifier
                .size(32.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF2F2F31)
                )
            )
            Icon(
                imageVector = iconSec,
                contentDescription = "arrow next",
                tint = Color(0xFF005695),
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}




@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController(), modifier = Modifier, sharedViewModel = SharedViewModel())
}