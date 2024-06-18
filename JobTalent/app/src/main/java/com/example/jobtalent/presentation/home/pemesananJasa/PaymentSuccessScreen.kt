
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
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
fun PaymentSuccessScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Pembayaran Sukses",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_black)),
                fontWeight = FontWeight(700),
                color = Color(0xFF000000)
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painter = painterResource(id = R.drawable.success), // Replace with your illustration drawable resource
            contentDescription = "Success Illustration",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Transaksi Anda telah berhasil \ndiselesaikan!",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(color = Color(0xFF005695), shape = RoundedCornerShape(size = 5.dp))
                .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF005695)
            ),
            onClick = { navController.navigate(Screen.Chat.route)}
        ) {
            Text(
                text = "Kembali ke Chat",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),

                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = { navController.navigate(Screen.Home.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF007BFF))
        ) {
            Text(
                text = "Kembali ke Home",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_bold)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@Composable
fun PaymentSuccessIllustration(illustration: Painter) {
    Image(
        painter = illustration,
        contentDescription = "Success Illustration",
        modifier = Modifier.size(200.dp)
    )
}

@Preview
@Composable
private fun PaymentSuccessScreenPreview() {
    PaymentSuccessScreen(navController = rememberNavController())
}