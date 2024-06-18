package com.example.jobtalent.presentation.login.model_login

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)