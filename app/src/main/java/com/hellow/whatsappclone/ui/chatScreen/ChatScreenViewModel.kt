package com.hellow.whatsappclone.ui.chatScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellow.whatsappclone.models.UserChatData
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl

class ChatScreenViewModel(
    app: Application,
    private val repository: RepositoryImpl,
    private val currentItem: UserItem
) :
    AndroidViewModel(app) {
    // to keep the current profile item alive
    private var _currentItem= MutableLiveData<UserItem>()
    val currentItemLiveData: LiveData<UserItem>
        get() = _currentItem
    fun getChatDataForUser(id:Int): UserChatData {
       return repository.getUserChat(id)
    }
    private var _text = MutableLiveData<String>("")
    val textLiveData: LiveData<String>
        get() = _text
    fun setText(value:String) {
         if(value!= _text.value){
             _text.value = value
         }
    }

    fun getChatListForUser(id:Int){
           repository.getUserChat(id)
    }
}