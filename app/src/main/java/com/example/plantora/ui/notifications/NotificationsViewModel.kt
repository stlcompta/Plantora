package com.example.plantora.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {
    val mail = MutableLiveData<String>()

//    private val _text = MutableLiveData<String>().apply {
//        value = "Fragment Profil"
//    }
//    val text: LiveData<String> = _text
    fun setData(newData: String){

        mail.value = newData
    }
}