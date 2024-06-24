package com.example.jobtalent.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.graphics.Color
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
import com.example.jobtalent.ui.theme.JobTalentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Postingan(
    navController: NavController
) {
    var posting by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .background(Color(0xfff8f8f8))
            .fillMaxSize()
            .padding(15.dp)
    ){
        Row {
            Box (
                modifier = Modifier.fillMaxWidth()
            ){
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
                Row (
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 2.dp)
                ){
                    Button(
                        onClick = { navController.popBackStack() },
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005695)),
                        contentPadding = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
                        modifier = Modifier
                            .requiredWidth(width = 84.dp)
                            .requiredHeight(height = 31.dp)
                    ) {
                        Row (
                            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .requiredWidth(width = 84.dp)
                                .requiredHeight(height = 31.dp)
                        ){
                            Text(
                                text = "Posting",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                    fontWeight = FontWeight(700),
                                    color = Color(0xFFFFFFFF),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(15.dp))
                .background(color = Color.White)
        ){
            Image(
                painter = painterResource(id = R.drawable.antobulat),
                contentDescription = "Anto",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 7.dp, y = 16.dp)
                    .requiredSize(35.dp)
                    .clip(shape = CircleShape)
            )
            TextField(
                value = posting,
                onValueChange = { posting = it},
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(color = Color(0xFF000000)),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 48.dp, y = 6.dp)
                    .fillMaxSize(),
                placeholder = {
                    Text(
                        text = "Apa yang anda pikirkan?",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_light)),
                            fontWeight = FontWeight(800),
                            color = Color(0xFF000000)
                        )
                    )
                }
            )
        }
    }
}

@Preview
@Composable
private fun PostinganPreview() {
    JobTalentTheme {
        Postingan(navController = rememberNavController())
    }
}