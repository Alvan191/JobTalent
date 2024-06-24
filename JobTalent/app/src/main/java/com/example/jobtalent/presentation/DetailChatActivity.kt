package com.example.jobtalent.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jobtalent.presentation.chat.ChatScreen
import com.example.jobtalent.ui.theme.JobTalentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JobTalentTheme {
                ChatScreen(modifier = Modifier, navController = rememberNavController())
            }
        }
    }
}