package com.hellow.whatsappclone.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellow.whatsappclone.R
import com.hellow.whatsappclone.databinding.UserListItemBinding
import com.hellow.whatsappclone.models.ChatType
import com.hellow.whatsappclone.models.UserItem

open class UserListAdaptor : RecyclerView.Adapter<UserListAdaptor.UserAdaptorHolder>() {


    inner class UserAdaptorHolder(val binding: UserListItemBinding) :
        RecyclerView.ViewHolder(binding.root)


    // for faster change in view
    private val differCallBack = object : DiffUtil.ItemCallback<UserItem>() {
        override fun areItemsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserItem, newItem: UserItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdaptorHolder {
        val binding: UserListItemBinding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserAdaptorHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: UserAdaptorHolder, position: Int) {
        // set Up View to the Item
        val currentItem = differ.currentList[holder.adapterPosition];

        holder.binding.apply {
            tvUserName.text = currentItem.UserName
            tvDate.text = currentItem.recentMessageTime
            Glide.with(holder.itemView.context).load(currentItem.profileUrl)
                .placeholder(R.drawable.user_profile_view_holder).dontAnimate().into(ivProfileImage)
            tvLastText.text = currentItem.lastMessageText
        }

        // set up chat item seen
        if (currentItem.isLastMessageSent) {
            holder.binding.ivLastSeen.visibility = View.VISIBLE
            if (currentItem.isLastMessageSeen) {
                holder.binding.ivLastSeen.setBackgroundResource(R.drawable.whats_app_double_check_seen)
            } else {

                holder.binding.ivLastSeen.setBackgroundResource(R.drawable.whats_app_double_check_not_seen)
            }
        } else {
            holder.binding.ivLastSeen.visibility = View.GONE
        }

        // set Up recent text view
        when (currentItem.lastMessageType) {
            ChatType.Audio -> {
                holder.binding.ivLastMessageNotText.visibility = View.VISIBLE
                holder.binding.ivLastMessageNotText.setBackgroundResource(R.drawable.last_message_audio)
            }

            ChatType.Data -> {
                holder.binding.ivLastMessageNotText.visibility = View.VISIBLE
                holder.binding.ivLastMessageNotText.setBackgroundResource(R.drawable.last_message_data)
            }

            ChatType.Image -> {
                holder.binding.ivLastMessageNotText.visibility = View.VISIBLE
                holder.binding.ivLastMessageNotText.setBackgroundResource(R.drawable.last_message_image)
            }

            ChatType.MultiImage -> {
                holder.binding.ivLastMessageNotText.visibility = View.VISIBLE
                holder.binding.ivLastMessageNotText.setBackgroundResource(R.drawable.last_message_image)
            }

            ChatType.Video -> {
                holder.binding.ivLastMessageNotText.visibility = View.VISIBLE
                holder.binding.ivLastMessageNotText.setBackgroundResource(R.drawable.last_message_video)
            }

            else -> {
                holder.binding.ivLastMessageNotText.visibility = View.GONE
            }
        }

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(currentItem)
            }
        }

    }

    private var onItemClickListener: ((UserItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (UserItem) -> Unit) {
        onItemClickListener = listener
    }


}