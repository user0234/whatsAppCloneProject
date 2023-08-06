package com.hellow.whatsappclone.ui.chatScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl

class ChatScreenViewModel(app: Application, private val repository: RepositoryImpl) :
    AndroidViewModel(app) {
    // to keep the current profile item alive
    private var _currentItem= MutableLiveData<UserItem>()
    val currentItemLiveData: LiveData<UserItem>
        get() = _currentItem

    fun setCurrentUser(item: UserItem){
        _currentItem.value = item
    }
}