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
    val id:Int,
    @TypeConverters(ChatItemTypeConverter::class)
    val type:ChatType,
    val text:String? = null,
    val linkText:Boolean = false,
    val imageLink:String? = null,
    val audio_length:String? = null,
    @TypeConverters(ChatMultiImageConverter::class)
    val multiImageLink:List<String>? = null,
    val unknownDataLink:String? = null,
    val profileId:String,
    val dateTime:String
) : Serializable