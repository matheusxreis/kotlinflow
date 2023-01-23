package com.matheusxreis.kotlinflow.models

data class Message(
    val text: String,
    val from: String,
    val to: String,
    val sentAt: Number
)
