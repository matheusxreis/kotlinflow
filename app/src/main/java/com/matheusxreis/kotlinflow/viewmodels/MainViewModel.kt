package com.matheusxreis.kotlinflow.viewmodels

import android.view.View
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheusxreis.kotlinflow.data.MessageRepository
import com.matheusxreis.kotlinflow.models.Message

class MainViewModel constructor(private val repository: MessageRepository): ViewModel() {

    val message:MutableLiveData<List<Message>> = MutableLiveData()

    fun observeMessages(){

        message.value = listOf<Message>(
            Message(text = "hello", "me", "you", 1212121212),
            Message(text = "how are you?", "me", "you", 1212121212),
            Message(text = "i'm missing you", "me", "you", 1212121212),
            Message(text = "can we see each other some day?", "me", "you", 1212121212),
        )
    }

    class MainViewModelFactory(
        private val repository: MessageRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }


    }
}