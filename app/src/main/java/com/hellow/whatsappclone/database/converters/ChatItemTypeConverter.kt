package com.hellow.whatsappclone.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.hellow.whatsappclone.models.ChatType

@ProvidedTypeConverter
class ChatItemTypeConverter {

    @TypeConverter
    fun toHealth(value: String) = enumValueOf<ChatType>(value)

    @TypeConverter
    fun fromHealth(value: ChatType) = value.name
}