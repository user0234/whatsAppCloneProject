package com.hellow.whatsappclone.repository

import androidx.lifecycle.LiveData
import com.hellow.TestData
import com.hellow.whatsappclone.database.ChatDataBase
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.UserChatData
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

    override fun getAllUsers(): List<UserItem> {
               return TestData.UsersList
    }

   override fun getUserChat(id:Int):UserChatData {
        return TestData.userData(id)
    }
}