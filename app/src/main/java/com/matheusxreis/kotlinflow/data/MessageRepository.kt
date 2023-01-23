package com.matheusxreis.kotlinflow.data

import com.matheusxreis.kotlinflow.models.Message
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MessageRepository {

    val messages = listOf(
        Message(text = "hello", from = "you", to = "me", sentAt = 1212121212),
        Message(text = "how are you?", from = "you", to = "me", sentAt = 1212121212),
        Message(text = "i'm missing you", from = "you", to = "me", sentAt = 1212121212),
        Message(
            text = "can we see each other some day?",
            from = "you",
            to = "me",
            sentAt = 1212121212
        ),
        Message(
            text = "hi, i dont know if it is a good idea",
            from = "me",
            to = "you",
            sentAt = 129182182
        ),
        Message(text = "why not?", from = "you", to = "me", sentAt = 192891829122),
        Message(text = "i think you know why", from = "me", to = "you", sentAt = 1289128912),
        Message(
            text = "let me the chance of apologize me",
            from = "you",
            to = "me",
            sentAt = 192871928192
        ),
        Message(text = "please...", from = "you", to = "me", sentAt = 192871928192),
        Message(text = "ok... where?", from = "me", to = "you", sentAt = 1289128912),
        Message(
            text = "same place, you won't regret",
            from = "you",
            to = "me",
            sentAt = 192871928192
        )
    )

    fun observeMessages(): Flow<Message> {
        return flow {
          for(message in messages){

              val time = ((1..3).random()*1000).toLong()
              delay(time)
              emit(message)
          }
        }
    }

}