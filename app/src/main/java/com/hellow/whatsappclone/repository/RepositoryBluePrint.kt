package com.hellow.whatsappclone.repository

import androidx.lifecycle.LiveData
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.UserItem

interface RepositoryBluePrint {

    suspend fun insertChat(item:ChatItem)

    suspend fun insertUser(item:UserItem)

    suspend  fun deleteUser(item:UserItem)

    suspend fun deleteChat(item:ChatItem)

    fun getAllUsers():LiveData<List<UserItem>>

    fun getChatOfUser(id:String):LiveData<List<ChatItem>>

}