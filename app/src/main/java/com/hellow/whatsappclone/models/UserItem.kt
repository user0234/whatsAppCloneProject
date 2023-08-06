package com.hellow.whatsappclone.models

import android.security.identity.AccessControlProfileId
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.hellow.whatsappclone.database.converters.ChatItemTypeConverter
import java.io.Serializable


@Entity(tableName = "Users")
data class UserItem (

    @PrimaryKey
    val id: String,
    val UserName:String,
    val isVerified:Boolean,
    val profileUrl:String,

    @TypeConverters(ChatItemTypeConverter::class)
    val lastMessageType:ChatType,
    val lastMessageText:String , // this is text in case of text , but in case of audio/image/video we add some other icons and time
    val isLastMessageSent:Boolean,
    val isLastMessageSeen:Boolean,
    val recentMessageTime:String,
        ):Serializable
