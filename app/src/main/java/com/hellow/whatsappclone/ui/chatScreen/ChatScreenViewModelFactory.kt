package com.hellow.whatsappclone.ui.chatScreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl

class ChatScreenViewModelFactory(private val app: Application,
                                 private val repository: RepositoryImpl,
                                 private val currentItem:UserItem
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatScreenViewModel(app,repository,currentItem) as T
    }
}