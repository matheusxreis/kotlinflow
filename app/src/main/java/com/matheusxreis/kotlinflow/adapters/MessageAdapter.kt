package com.matheusxreis.kotlinflow.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matheusxreis.kotlinflow.databinding.MessageRowLayoutBinding
import com.matheusxreis.kotlinflow.models.Message

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    val messages = listOf<Message>()
    class MessageViewHolder(private val binding: MessageRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message){
            binding.message = message
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MessageRowLayoutBinding.inflate(layoutInflater, parent, false)
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(messages[position])
    }

    override fun getItemCount(): Int = messages.size

}