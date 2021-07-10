package com.example.homeworks.homework16

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworks.databinding.ItemMessageBinding

class MessagesAdapter(
    private var messagesList: MutableList<Message> = mutableListOf(),
    private val click: (Message) -> Unit = {}
) : RecyclerView.Adapter<MessagesAdapter.MessageViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MessagesAdapter.MessageViewHolder {
        return MessageViewHolder(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            click
        )
    }

    override fun onBindViewHolder(holder: MessagesAdapter.MessageViewHolder, position: Int) {
        holder.bind(messagesList[position])
    }

    override fun getItemCount(): Int = messagesList.size

    fun update(list: MutableList<Message>) {
        messagesList.clear()
        messagesList.addAll(list)
        notifyDataSetChanged()
    }

    class MessageViewHolder(
        private val binding: ItemMessageBinding,
        private var click: (Message) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.tvMessage.text = item.message
            binding.tvDate.text = item.date

            itemView.setOnLongClickListener {
                click(item)
                true
            }
        }
    }
}