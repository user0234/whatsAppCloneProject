package com.hellow.whatsappclone.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hellow.whatsappclone.database.converters.ChatItemTypeConverter
import com.hellow.whatsappclone.database.converters.ChatMultiImageConverter
import java.io.Serializable

@Entity(tableName = "Chat")
data class ChatItem(
    @PrimaryKey
    val id:String,

    @TypeConverters(ChatItemTypeConverter::class)
    val Type:ChatType,
    val isSenderMe:Boolean,
    val text:String? = null,
    val linkText:String? = null,
    val imageLink:String? = null,
    val audioLink:String? = null,

    @TypeConverters(ChatMultiImageConverter::class)
    val multiImageLink:List<String>? = null,
    val dataLink:String? = null,
    val profileId:String,
) : Serializable