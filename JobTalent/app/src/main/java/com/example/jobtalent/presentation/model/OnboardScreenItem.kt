package com.example.jobtalent.presentation.model

import androidx.annotation.RawRes

data class OnboardScreenItem(
    @RawRes
    val resId: Int,
    val title: String,
    val description: String
)