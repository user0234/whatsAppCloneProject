package com.hellow.whatsappclone.ui.userScreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hellow.whatsappclone.repository.RepositoryImpl

class UserScreenViewModelFactory(
    private val app: Application,
    private val repository: RepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserScreenViewModel(app,repository) as T
    }

}