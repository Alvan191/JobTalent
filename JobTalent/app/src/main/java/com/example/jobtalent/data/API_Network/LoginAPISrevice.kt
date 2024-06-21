package com.example.jobtalent.data.API_Network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPISrevice{
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest) : Response<LoginResponse>
}

data class LoginRequest(
    val email : String,
    val password : String
)

data class LoginResponse(
    val authorization : String
)