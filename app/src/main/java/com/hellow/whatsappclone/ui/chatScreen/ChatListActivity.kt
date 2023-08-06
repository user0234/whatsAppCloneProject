package com.hellow.whatsappclone.ui.chatScreen

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.hellow.whatsappclone.R
import com.hellow.whatsappclone.database.ChatDataBase
import com.hellow.whatsappclone.databinding.ActivityChatListBinding
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl
import com.hellow.whatsappclone.ui.userScreen.UserScreenViewModel
import com.hellow.whatsappclone.ui.userScreen.UserScreenViewModelFactory

class ChatListActivity : AppCompatActivity() {

    lateinit var binding:ActivityChatListBinding
    lateinit var viewModel:ChatScreenViewModel
    lateinit var currentUserItem:UserItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatRepository = RepositoryImpl(ChatDataBase(this)!!)
        val viewModelProviderFactory = ChatScreenViewModelFactory(application, chatRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory )[ChatScreenViewModel::class.java]


        if (intent.hasExtra("userProfile")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                currentUserItem = intent.getSerializableExtra(
                    "userProfile",
                    UserItem::class.java
                )!!
                viewModel.setCurrentUser(
                    currentUserItem
                )
            } else {
                currentUserItem = (intent.getSerializableExtra("userProfile") as UserItem?)!!
                viewModel.setCurrentUser(currentUserItem)
            }


        }
        setUpToolBar()

    }

    fun setUpToolBar(){
        setSupportActionBar(binding.toolBar)
        binding.titleTextViewChatRoom.text = currentUserItem.UserName
        Glide.with(applicationContext).load(currentUserItem.profileUrl)
            .placeholder(R.drawable.user_profile_view_holder).dontAnimate().into(binding.ivProfileImage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.chat_room_app_bar, menu)
        return true
    }
}