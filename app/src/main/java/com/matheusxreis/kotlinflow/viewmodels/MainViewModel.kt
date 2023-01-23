package com.matheusxreis.kotlinflow.viewmodels

import android.util.Log
import android.view.View
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.*
import com.matheusxreis.kotlinflow.data.MessageRepository
import com.matheusxreis.kotlinflow.models.Message
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: MessageRepository) : ViewModel() {

    val message: MutableLiveData<List<Message>> = MutableLiveData()

    init {
        message.value = listOf()
    }

    fun observeMessages() = GlobalScope.launch {
        repository.observeMessages().collect { m ->
            updateLiveData(m)
        }

    }

    private fun updateLiveData(m: Message) {
         val value = message.value?.plus(m)
         message.postValue(value)
    }


    class MainViewModelFactory(
        private val repository: MessageRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(repository) as T
        }


    }
}