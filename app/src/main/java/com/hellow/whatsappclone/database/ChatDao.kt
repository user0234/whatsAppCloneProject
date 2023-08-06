package com.hellow.whatsappclone.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.UserItem

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertUser(item: UserItem): Long

    @Delete
    suspend  fun deleteUser(item: UserItem)

    @Query("Select * From Users")
    fun getAllUsers(): LiveData<List<UserItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertChat(item: ChatItem)

    @Delete
    suspend  fun deleteChat(item: ChatItem)

    @Query("Select * From Chat Where profileId =:id")
    fun getChatOfUser(id: String): LiveData<List<ChatItem>>

}