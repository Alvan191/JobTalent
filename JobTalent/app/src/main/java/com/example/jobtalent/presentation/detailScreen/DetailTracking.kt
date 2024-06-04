
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
                text = "   Tracking Progress",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000)
                )
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        TextSection(
            title = "Estimasi Selesai",
            content = "Apr 05, 2024"
        )
        TextSection(
            title = "Status",
            content = "Proses Pengerjaan",
            contentColor = Color.Green
        )
        TextSection(
            title = "Jenis Pekerjaan",
            content = "Menjahit kebaya wisuda"
        )
        HistorySection()
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.navigate(Screen.Ratingsc.route)},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(text = "Beri Penilaian", color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun TextSection(title: String, content: String, contentColor: Color = Color.Black) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 16.sp, color = Color.Black)
        Text(text = content, fontSize = 16.sp, color = contentColor)
    }
}

@Composable
fun HistorySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Riwayat", fontSize = 18.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        HistoryItem(date = "Apr 03", time = "18.20", description = "Diterima")
        HistoryItem(date = "Apr 04", time = "09.00", description = "Proses perancangan")
        HistoryItem(date = "Apr 04", time = "13.00", description = "Proses penjahitan")
    }
}

@Composable
fun HistoryItem(date: String, time: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = date, fontSize = 16.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(Color.Blue)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = time, fontSize = 12.sp, color = Color.Gray)
            Text(text = description, fontSize = 16.sp, color = Color.Black)
        }
    }
}

