package com.example.jobtalent.presentation.model

data class CommunityPost(
    val image: Int,
    val name: String,
    val time: String,
    val desc_content: String,
    val image_content: Int? = null,
    val like: String,
    val comment: String
)