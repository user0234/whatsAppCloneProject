package com.hellow.whatsappclone.ui.userScreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl
import kotlinx.coroutines.launch

class UserScreenViewModel(
    app: Application, private val repository: RepositoryImpl
):AndroidViewModel(app) {


    // create new user
    fun insert(item:UserItem){
        viewModelScope.launch {
            repository.insertUser(item)
        }

    }

    fun deleteUser(item:UserItem){
        viewModelScope.launch {
            repository.deleteUser(item)
        }
    }

    fun getUserList() = repository.getAllUsers()

}