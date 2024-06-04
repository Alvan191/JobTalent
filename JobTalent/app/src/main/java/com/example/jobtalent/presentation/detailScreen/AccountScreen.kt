package com.example.jobtalent.presentation.detailScreen


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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountScreen() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Akun Saya") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back navigation */ }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            var namaLengkap by remember { mutableStateOf("") }
            var nomorTelepon by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var kataSandi by remember { mutableStateOf("") }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(text = "Nama Lengkap")
                OutlinedTextField(
                    value = namaLengkap,
                    onValueChange = { namaLengkap = it },
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.user1),
                            contentDescription = "Nama Lengkap",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Nomor Telepon")
                OutlinedTextField(
                    value = nomorTelepon,
                    onValueChange = { nomorTelepon = it },
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.phone),
                            contentDescription = "Nomor Telepon",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Email")
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Email",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "Kata Sandi")
                OutlinedTextField(
                    value = kataSandi,
                    onValueChange = { kataSandi = it },
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.password),
                            contentDescription = "Kata Sandi",
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(
                            color = Color(0xFF005695),
                            shape = RoundedCornerShape(size = 5.dp)
                        )
                        .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF005695)
                    ),

                    onClick = { }
                ) {
                    Text(text = "Simpan")
                }
            }
        }
    }
}






@Preview
@Composable
private fun AccountScreenPreview() {
    AccountScreen()
}