package com.hellow.whatsappclone.repository

import androidx.lifecycle.LiveData
import com.hellow.whatsappclone.database.ChatDataBase
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.UserItem

class RepositoryImpl(
    private val database:ChatDataBase
):RepositoryBluePrint {


    override suspend fun insertChat(item: ChatItem) {
        database.ChatDao().insertChat(item)
    }

    override suspend fun insertUser(item: UserItem) {
        database.ChatDao().insertUser(item)
    }

    override suspend fun deleteUser(item: UserItem) {
        database.ChatDao().deleteUser(item)
    }

    override suspend fun deleteChat(item: ChatItem) {
        database.ChatDao().deleteChat(item)

    }

    override fun getAllUsers(): LiveData<List<UserItem>> {
               return database.ChatDao().getAllUsers()
    }

    override fun getChatOfUser(id: String): LiveData<List<ChatItem>> {
        return database.ChatDao().getChatOfUser(id)
    }
}