package com.example.jobtalent.presentation.detailScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSettingsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Bahasa") },
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
                .padding(16.dp)
        ) {
            var selectedLanguage by remember { mutableStateOf("Indonesia (ID)") }

            LanguageOption(
                language = "Indonesia (ID)",
                isSelected = selectedLanguage == "Indonesia (ID)",
                onSelect = { selectedLanguage = it }
            )
            LanguageOption(
                language = "English (US)",
                isSelected = selectedLanguage == "English (US)",
                onSelect = { selectedLanguage = it }
            )
        }
    }
}

@Composable
fun LanguageOption(language: String, isSelected: Boolean, onSelect: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(language) }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = language, fontSize = 16.sp, modifier = Modifier.weight(1f))
        RadioButton(
            selected = isSelected,
            onClick = { onSelect(language) }
        )
    }
}

@Preview
@Composable
private fun LanguageSettingsScreenPreview() {
    LanguageSettingsScreen()
}