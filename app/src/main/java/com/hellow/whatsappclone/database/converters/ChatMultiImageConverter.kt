package com.hellow.whatsappclone.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

@ProvidedTypeConverter
class ChatMultiImageConverter {

    @TypeConverter
    fun fromLinks(value: List<String>?) : String {
        if (value != null) {
            if (value.isEmpty()) {
                return ("");
            }
        }else{
            return ("");
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.toJson(value, type)
    }


    @TypeConverter
    fun toLinks(data: String):List<String>? {
        if (data == "") {
            return (null);
        }
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(data, type)
    }

}