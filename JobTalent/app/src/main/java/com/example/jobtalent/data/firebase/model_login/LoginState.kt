package com.example.jobtalent.data.firebase.model_login

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)