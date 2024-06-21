package com.example.jobtalent.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobtalent.data.API_Network.LoginRequest
import com.example.jobtalent.data.API_Network.LoginResponse
import com.example.jobtalent.data.Module.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class LoginViewModel :ViewModel() {
    private val apiService = RetrofitInstance.loginAPI

    fun loginUser(request : LoginRequest, onSuccess: (LoginResponse) -> Unit, onError: (String) -> Unit){
        viewModelScope.launch {
            try {
                val response : Response<LoginResponse> = apiService.loginUser(request)
                if (response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!)
                } else {
                    onError(response.message())
                }
            } catch (e : HttpException) {
                onError(e.message())
            } catch (e : Exception){
                onError(e.message ?: "Unknow Err")
            }
        }
    }

}