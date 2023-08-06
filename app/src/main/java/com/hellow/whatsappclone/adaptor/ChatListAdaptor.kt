package com.hellow.whatsappclone.adaptor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hellow.whatsappclone.databinding.TextTypeChatListLayoutNotSentBinding
import com.hellow.whatsappclone.databinding.TextTypeChatListLayoutSentBinding
import com.hellow.whatsappclone.databinding.UserListItemBinding

class ChatListAdaptor: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private inner class textTypeSentViewHolder(val binding:TextTypeChatListLayoutSentBinding):RecyclerView.ViewHolder(binding.root)

    private inner class textTypeNotSentViewHolder(val binding: TextTypeChatListLayoutNotSentBinding):RecyclerView.ViewHolder(binding.root)
















    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}