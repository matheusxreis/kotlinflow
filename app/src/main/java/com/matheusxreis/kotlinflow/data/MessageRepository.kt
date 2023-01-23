package com.matheusxreis.kotlinflow.data

import com.matheusxreis.kotlinflow.models.Message

class MessageRepository {

    fun observeMessages(): List<Message> {
        return listOf(
            Message(text = "hello", "me", "you", 1212121212),
            Message(text = "how are you?", "me", "you", 1212121212),
            Message(text = "i'm missing you", "me", "you", 1212121212),
            Message(text = "can we see each other some day?", "me", "you", 1212121212)
        )
    }

}