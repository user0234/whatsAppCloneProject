package com.hellow.whatsappclone.ui.chatScreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellow.whatsappclone.repository.RepositoryImpl
import com.hellow.whatsappclone.ui.userScreen.UserScreenViewModel

class ChatScreenViewModelFactory(private val app: Application,
                                 private val repository: RepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChatScreenViewModel(app,repository) as T
    }
}