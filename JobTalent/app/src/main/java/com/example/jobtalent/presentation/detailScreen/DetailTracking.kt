
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.R
import com.example.jobtalent.navigation.Screen


@Composable
fun TrackingScreen(
    navController: NavController
) {
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFF8F8F8)
            ),
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
                .background(
                    color = Color(0xFFF8F8F8)
                ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
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
                Text(
                    text = "Tracking Progress",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF000000)
                    ),
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(5.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.anto),
                        contentDescription = "Anto",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Column(
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Anto Ramadhan",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                fontWeight = FontWeight(500),
                                color = Color(0xFF000000),
                            )
                        )
                        Text(
                            text = "Penjahit",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFB2B2B2),
                            )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(45.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .shadow(5.dp, RoundedCornerShape(5.dp))
                            .background(Color.White)
                            .clickable(onClick = { navController.navigate(Screen.Chat.route) })
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bubble_chat),
                            contentDescription = "Chat",
                            tint = Color(0xff0060a5),
                            modifier = Modifier
                                .size(25.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                TextSection(
                    title = "Estimasi Selesai",
                    content = "Apr 05, 2024"
                )
                TextSection(
                    title = "Status",
                    content = "Proses Pengerjaan",
                    contentColor = Color.Green
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            TextSection(
                title = "Jenis Pekerjaan",
                content = "Menjahit kebaya wisuda"
            )
            Spacer(modifier = Modifier.height(30.dp))
            HistorySection()
        }

        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 20.dp)
        ){
            Button(
                onClick = { navController.navigate(Screen.Ratingsc.route) },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .width(250.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005695))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.StarBorder,
                        contentDescription = "Star",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Beri Penilaian",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_black)),
                            fontWeight = FontWeight(500),
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun TextSection(title: String, content: String, contentColor: Color = Color.Black) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = content,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(600),
                color = contentColor,
            )
        )
    }
}

@Composable
fun HistorySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Riwayat",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(185.dp)
            ){
                HistoryItem(date = "Apr 03", time = "18.20")
                HistoryItem(date = "Apr 04", time = "09.00")
                HistoryItem(date = "Apr 04", time = "13.00")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Image(
                painter = painterResource(id = R.drawable.track),
                contentDescription = "track",
                modifier = Modifier
                    .height(185.dp)
                    .width(30.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column (
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .height(185.dp)
            ){
                DescItem(description = "Diterima")
                DescItem(description = "Proses Perancangan")
                DescItem(description = "Proses Penjahitan")
            }
        }
    }
}

@Composable
fun HistoryItem(date: String, time: String,) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = date,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = time,
            style = TextStyle(
                fontSize = 11.sp,
                fontFamily = FontFamily(Font(R.font.roboto_light)),
                fontWeight = FontWeight(400),
                color = Color(0xFFB2B2B2),
            )
        )
    }
}

@Composable
fun DescItem(description: String) {
    Text(
        text = description,
        style = TextStyle(
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.roboto_light)),
            fontWeight = FontWeight(400),
            color = Color(0xFF000000),)
    )
}

@Preview
@Composable
private fun Trackprev() {
    TrackingScreen(navController = rememberNavController())
}
