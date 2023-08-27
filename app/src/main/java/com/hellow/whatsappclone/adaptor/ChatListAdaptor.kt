package com.hellow.whatsappclone.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hellow.whatsappclone.databinding.AudioTypeChatListLayoutNotSentBinding
import com.hellow.whatsappclone.databinding.AudioTypeChatListLayoutSentBinding
import com.hellow.whatsappclone.databinding.MultiImageChatListItemNotSentBinding
import com.hellow.whatsappclone.databinding.MultiImageChatListItemSentBinding
import com.hellow.whatsappclone.databinding.SingleImageTypeChatListItemNotSentBinding
import com.hellow.whatsappclone.databinding.SingleImageTypeChatListItemSentBinding
import com.hellow.whatsappclone.databinding.TextTypeChatListLayoutNotSentBinding
import com.hellow.whatsappclone.databinding.TextTypeChatListLayoutSentBinding
import com.hellow.whatsappclone.databinding.VideoTypeChatListLayoutNotSentBinding
import com.hellow.whatsappclone.databinding.VideoTypeChatListLayoutSentBinding
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.ChatType

class ChatListAdaptor : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // for faster change in view
    private val differCallBack = object : DiffUtil.ItemCallback<ChatItem>() {
        override fun areItemsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ChatItem, newItem: ChatItem): Boolean {
            return oldItem.type == newItem.type
        }

    }

   val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ChatType.TextSent.ordinal -> {
                val view = TextTypeChatListLayoutSentBinding.inflate(inflater, parent, false)
                TextTypeSentViewHolder(view)
            }

            ChatType.TextNotSent.ordinal -> {
                val view = TextTypeChatListLayoutNotSentBinding.inflate(inflater, parent, false)
                TextTypeNotSentViewHolder(view)
            }

            ChatType.ImageSent.ordinal -> {
                val view = SingleImageTypeChatListItemSentBinding.inflate(inflater, parent, false)
                ImageTypeSentViewHolder(view)
            }

            ChatType.ImageNotSent.ordinal -> {
                val view =
                    SingleImageTypeChatListItemNotSentBinding.inflate(inflater, parent, false)
                ImageTypeNotSentViewHolder(view)
            }

            ChatType.MultiImageSent.ordinal -> {
                val view = MultiImageChatListItemSentBinding.inflate(inflater, parent, false)
                MultiImageTypeSentViewHolder(view)
            }

            ChatType.MultiImageNotSent.ordinal -> {
                val view = MultiImageChatListItemNotSentBinding.inflate(inflater, parent, false)
                MultiImageTypeNotSentViewHolder(view)
            }

            ChatType.VideoSent.ordinal -> {
                val view = VideoTypeChatListLayoutSentBinding.inflate(inflater, parent, false)
                VideoTypeSentViewHolder(view)
            }

            ChatType.VideoNotSent.ordinal -> {
                val view = VideoTypeChatListLayoutNotSentBinding.inflate(inflater, parent, false)
                VideoTypeNotSentViewHolder(view)
            }

            ChatType.AudioSent.ordinal -> {
                val view = AudioTypeChatListLayoutSentBinding.inflate(inflater, parent, false)
                AudioTypeSentViewHolder(view)
            }

            ChatType.AudioNotSent.ordinal -> {
                val view = AudioTypeChatListLayoutNotSentBinding.inflate(inflater, parent, false)
                AudioTypeNotSentViewHolder(view)
            }

            else -> {
                TextTypeSentViewHolder(
                    TextTypeChatListLayoutSentBinding.inflate(inflater, parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = differ.currentList[position]

        when (item.type.ordinal) {
            ChatType.TextSent.ordinal -> {
                (holder as TextTypeSentViewHolder).bind(item)
            }

            ChatType.TextNotSent.ordinal -> {
                (holder as TextTypeNotSentViewHolder).bind(item)

            }

            ChatType.ImageSent.ordinal -> {
                (holder as ImageTypeSentViewHolder).bind(item)
            }

            ChatType.ImageNotSent.ordinal -> {
                (holder as ImageTypeNotSentViewHolder).bind(item)
            }

            ChatType.MultiImageSent.ordinal -> {
                (holder as MultiImageTypeSentViewHolder).bind(item)

            }

            ChatType.MultiImageNotSent.ordinal -> {
                (holder as MultiImageTypeNotSentViewHolder).bind(item)
            }

            ChatType.VideoSent.ordinal -> {
                (holder as VideoTypeSentViewHolder).bind(item)

            }

            ChatType.VideoNotSent.ordinal -> {
                (holder as VideoTypeNotSentViewHolder).bind(item)

            }

            ChatType.AudioSent.ordinal -> {
                (holder as AudioTypeSentViewHolder).bind(item)

            }

            ChatType.AudioNotSent.ordinal -> {
                (holder as AudioTypeNotSentViewHolder).bind(item)
            }

            else -> {
                (holder as TextTypeSentViewHolder).bind(item)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return differ.currentList[position].type.ordinal
    }

}