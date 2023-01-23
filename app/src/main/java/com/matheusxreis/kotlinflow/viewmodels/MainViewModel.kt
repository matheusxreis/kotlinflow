package com.matheusxreis.kotlinflow.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheusxreis.kotlinflow.models.Message

class MainViewModel: ViewModel() {

    val message:MutableLiveData<List<Message>> = MutableLiveData()

    fun observeMessages(){

        message.value = listOf<Message>(
            Message(text = "hello", "me", "you", 1212121212),
            Message(text = "how are you?", "me", "you", 1212121212),
            Message(text = "i'm missing you", "me", "you", 1212121212),
            Message(text = "can we see each other some day?", "me", "you", 1212121212),
        )
    }
}