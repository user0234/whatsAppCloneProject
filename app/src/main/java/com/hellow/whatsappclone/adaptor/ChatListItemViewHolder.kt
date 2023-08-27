package com.hellow.whatsappclone.adaptor

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hellow.whatsappclone.R
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


class TextTypeSentViewHolder(private val binding: TextTypeChatListLayoutSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime.text = item.dateTime
        binding.tvText.text = item.text
    }
}

class TextTypeNotSentViewHolder(private val binding: TextTypeChatListLayoutNotSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvText.text = item.text
        binding.tvTime.text = item.dateTime
    }
}

class ImageTypeSentViewHolder(private val binding: SingleImageTypeChatListItemSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.imageLink)
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage)

    }
}

class ImageTypeNotSentViewHolder(private val binding: SingleImageTypeChatListItemNotSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.imageLink)
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage)
    }
}

class MultiImageTypeSentViewHolder(private val binding: MultiImageChatListItemSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime1.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink!![0])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage1)
        binding.tvTime2.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[1])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage2)
        binding.tvTime3.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[2])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage3)
        binding.tvTime4.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[3])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage4)
    }
}

class MultiImageTypeNotSentViewHolder(private val binding: MultiImageChatListItemNotSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime1.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink!![0])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage1)
        binding.tvTime2.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[1])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage2)
        binding.tvTime3.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[2])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage3)
        binding.tvTime4.text = item.dateTime
        Glide
            .with(binding.root)
            .load(item.multiImageLink[3])
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage4)
    }
}

class VideoTypeSentViewHolder(private val binding: VideoTypeChatListLayoutSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
         binding.tvTime.text = item.dateTime
         binding.tvText.text = item.text
        Glide
            .with(binding.root)
            .load(item.imageLink)
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage)
    }
}

class VideoTypeNotSentViewHolder(private val binding: VideoTypeChatListLayoutNotSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime.text = item.dateTime
        binding.tvText.text = item.text
        Glide
            .with(binding.root)
            .load(item.imageLink)
            .centerCrop()
            .placeholder(R.drawable.chat_item_image_place_holder)
            .into(binding.ivImage)
    }
}

class AudioTypeSentViewHolder(private val binding: AudioTypeChatListLayoutSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
          binding.tvTime.text = item.dateTime
        binding.tvText.text = item.text
        binding.tvLength.text = item.audio_length
    }
}

class AudioTypeNotSentViewHolder(private val binding: AudioTypeChatListLayoutNotSentBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ChatItem) {
        binding.tvTime.text = item.dateTime
        binding.tvText.text = item.text
        binding.tvLength.text = item.audio_length
    }
}