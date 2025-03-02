package com.ducfore.foododering.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ducfore.foododering.databinding.NotificationItemBinding

class NotificationAdapter(
    private var notificationText:ArrayList<String>,
    private var notificationImage:ArrayList<Int>
) :RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {
    class NotificationViewHolder(private val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notificationTxt: String, notificationImg: Int) {
            binding.notificationText.text = notificationTxt
            binding.notificationImage.setImageResource(notificationImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationAdapter.NotificationViewHolder {
        val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationAdapter.NotificationViewHolder, position: Int) {
        holder.bind(notificationText[position],notificationImage[position])
    }

    override fun getItemCount(): Int {
       return notificationText.size
    }
}