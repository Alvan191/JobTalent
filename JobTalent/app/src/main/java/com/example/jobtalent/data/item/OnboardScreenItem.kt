package com.example.jobtalent.data.item

import androidx.annotation.RawRes

data class OnboardScreenItem(
    @RawRes
    val resId: Int,
    val title: String,
    val description: String
)