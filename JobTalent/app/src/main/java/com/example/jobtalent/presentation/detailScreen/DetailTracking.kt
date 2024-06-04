
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TrackingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
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
        TextSection(
            title = "Jenis Pekerjaan",
            content = "Menjahit kebaya wisuda"
        )
        HistorySection()
        Spacer(modifier = Modifier.height(16.dp))
        FeedbackButton()
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

@Composable
fun FeedbackButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
    ) {
        Text(text = "Beri Penilaian", color = Color.White, fontSize = 16.sp)
    }
}
