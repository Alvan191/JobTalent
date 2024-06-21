package com.example.jobtalent.data.API_Network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterAPIService{
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest) : Response<RegisterResponse>
}

data class RegisterResponse(
    val username : String,
    val hash : String
)

data class RegisterRequest(
    val username: String,
    val email : String,
    val password : String,
    val confPassword : String
)

