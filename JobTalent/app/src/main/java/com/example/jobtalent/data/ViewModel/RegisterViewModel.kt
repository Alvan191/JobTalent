package com.example.jobtalent.data.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jobtalent.data.API_Network.RegisterRequest
import com.example.jobtalent.data.API_Network.RegisterResponse
import com.example.jobtalent.data.Module.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class RegisterViewModel:ViewModel(){
    private val apiService = RetrofitInstance.registerAPI

    fun registerUser(request : RegisterRequest, onSuccess : (RegisterResponse) -> Unit, onError: (String) -> Unit){
        viewModelScope.launch {
            try {
                val response : Response<RegisterResponse> = apiService.registerUser(request)
                if (response.isSuccessful && response.body() != null) {
                    onSuccess(response.body()!!)
                } else{
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
