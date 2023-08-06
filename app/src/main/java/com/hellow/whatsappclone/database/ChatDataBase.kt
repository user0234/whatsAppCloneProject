package com.hellow.whatsappclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hellow.whatsappclone.database.converters.ChatItemTypeConverter
import com.hellow.whatsappclone.database.converters.ChatMultiImageConverter
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.UserItem


@Database(entities = [UserItem::class,ChatItem::class], version = 1, exportSchema = false)
@TypeConverters(ChatItemTypeConverter::class,ChatMultiImageConverter::class)
abstract class ChatDataBase : RoomDatabase() {

abstract fun ChatDao(): ChatDao

    companion object {

        @Volatile
        private var instance: ChatDataBase? = null
        private val LOCK = Any()

        // singleton pattern
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            val INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ChatDataBase::class.java,
                "chat.db")
                .addTypeConverter(ChatItemTypeConverter())
                .addTypeConverter(ChatMultiImageConverter())
                .build()
            instance = INSTANCE

            instance
        }

    }

}