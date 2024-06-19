package com.example.jobtalent.presentation.profile.model_view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _imageUri = MutableLiveData<String>()
    val imageUri: LiveData<String> = _imageUri

    fun updateImageUri(uri: String) {
        _imageUri.value = uri
    }
}