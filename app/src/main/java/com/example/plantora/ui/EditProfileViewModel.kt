package com.example.plantora.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragment editprofile"
    }
    val text: LiveData<String> = _text
}