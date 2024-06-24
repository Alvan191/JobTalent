package com.example.jobtalent.presentation.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.jobtalent.R
import com.example.jobtalent.presentation.model.OnboardScreenItem
import com.example.jobtalent.data.onboard.DataOnboard
import com.example.jobtalent.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val onBoard = DataOnboard.OnBoardItems

    SplashScreenNewContent(
        onBoardings = onBoard,
        moveToLogin = {
            navController.navigate(Screen.Login.route){
                popUpTo(Screen.Onboarding.route) {
                    inclusive = true
                }
            }
        },
        modifier = modifier

    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SplashScreenNewContent(
    onBoardings: List<OnboardScreenItem>,
    moveToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { onBoardings.size })
    val (selectedPage, setSelectedPage) = remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            setSelectedPage(page)
        }
    }

    Scaffold {
        Column(modifier = modifier
            .background(
                color = Color(0xFF8BC4ED)
            )
            .padding(it)) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(0.6f)
            ) { page ->
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.RawRes(
                        onBoardings[page].resId
                    )
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF8BC4ED)
                        )
                        .padding(24.dp)
                ) {
                    Spacer(modifier = Modifier.height(35.dp))
                    Row (
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = onBoardings[page].title,
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_black)),
                                fontWeight = FontWeight(700),
                                color = Color(0xFFFFFFFF)
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Text(
                        text = onBoardings[page].description,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFFFFFFFF)
                        )
                    )
                    LottieAnimation(
                        composition,
                        iterations = LottieConstants.IterateForever,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                for (i in onBoardings.indices) {
                    Box(
                        modifier = Modifier
                            .padding(end = if (i == onBoardings.size - 1) 0.dp else 5.dp)
                            .width(if (i == selectedPage) 20.dp else 10.dp)
                            .height(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                if (i == selectedPage) Color.White else MaterialTheme.colorScheme.primary.copy(
                                    alpha = 0.1f
                                )
                            )
                    )
                }
            }

            if (selectedPage != onBoardings.size - 1) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    TextButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(onBoardings.size - 1)
                            }
                        },
                        modifier = Modifier.height(48.dp)
                    ) {
                        Text(
                            text = "Lewati",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF)
                            )
                        )
                    }

                    Button(
                        onClick = {
                            scope.launch {
                                val nextPage = selectedPage + 1
                                pagerState.animateScrollToPage(nextPage)
                            }
                        },
                        modifier = Modifier
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF005695)
                        )
                    ) {
                        Text(
                            text = "Next",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF)
                            )
                        )
                    }
                }
            }

            if (selectedPage == onBoardings.size - 1) {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Button(
                        onClick = {
                            moveToLogin()
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF005695)
                        )
                    ) {
                        Text(
                            text = "Mulai",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF)
                            )
                        )
                    }
                }
            }
        }
    }
}
