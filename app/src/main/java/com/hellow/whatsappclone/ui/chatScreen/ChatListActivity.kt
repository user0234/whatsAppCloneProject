package com.hellow.whatsappclone.ui.chatScreen

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.hellow.whatsappclone.R
import com.hellow.whatsappclone.adaptor.ChatListAdaptor
import com.hellow.whatsappclone.database.ChatDataBase
import com.hellow.whatsappclone.databinding.ActivityChatListBinding
import com.hellow.whatsappclone.models.UserItem
import com.hellow.whatsappclone.repository.RepositoryImpl

class ChatListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatListBinding
    lateinit var viewModel: ChatScreenViewModel
    private lateinit var currentUserItem: UserItem
    private lateinit var adaptor: ChatListAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("userProfile")) {
            currentUserItem = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra(
                    "userProfile",
                    UserItem::class.java
                )!!
            } else {
                (intent.getSerializableExtra("userProfile") as UserItem?)!!
            }
        }

        val chatRepository = RepositoryImpl(ChatDataBase(this)!!)
        val viewModelProviderFactory =
            ChatScreenViewModelFactory(application, chatRepository, currentUserItem)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory)[ChatScreenViewModel::class.java]

        setUpToolBar()
        setUpChatOption()
        setUpChatListAdaptor()
    }

    private fun setUpChatListAdaptor() {
        adaptor = ChatListAdaptor()
        binding.rvChatList.adapter = adaptor
        binding.rvChatList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        binding.rvChatList.setHasFixedSize(false)
        val userData = viewModel.getChatDataForUser(currentUserItem.id);
        adaptor.differ.submitList(userData.data)

        binding.rvChatList.scrollToPosition(userData.data.size - 1)
    }

    private fun setUpChatOption() {
        binding.emojiButton.setOnClickListener {
            // set focus to edit text and open emoji keyboard
            showKeyBoardWithEmoji()
            binding.etMessage.requestFocus()
        }
        binding.cameraButton.setOnClickListener {
            // open button for camera

        }
        binding.attachmentButton.setOnClickListener {
            // open dialog for adding files button list

        }
        viewModel.textLiveData.observe(this) {
            binding.etMessage.setText(it)
        }

        binding.etMessage.setOnFocusChangeListener { view, hasfocus ->
            if (!hasfocus) {
                viewModel.setText(binding.etMessage.text.toString())
            }
        }

        binding.etMessage.addTextChangedListener {
            if (it.toString() == "") {
                showButtons()
            } else {
                hideButtons()
            }
        }

    }

    private fun showButtons() {

        binding.cameraButton.animate()
            .alpha(1f)
            .translationX(1f)
            .withStartAction {
                binding.cameraButton.visibility = View.VISIBLE

            }
            .setDuration(200)
            .start()
        binding.audioRecorderButton.setImageResource(R.drawable.last_message_audio)


    }

    private fun hideButtons() {

        binding.cameraButton.animate()
            .alpha(0f)
            .translationX(100f)
            .withEndAction {
                binding.cameraButton.visibility = View.GONE

            }
            .setDuration(200)
            .start()
        binding.audioRecorderButton.setImageResource(R.drawable.baseline_send_24)
    }

    private fun showKeyBoardWithEmoji() {

    }

    private fun setUpToolBar() {
        setSupportActionBar(binding.toolBar)
        binding.titleTextViewChatRoom.text = currentUserItem.UserName
        Glide.with(applicationContext).load(currentUserItem.profileUrl)
            .placeholder(R.drawable.user_profile_view_holder).dontAnimate()
            .into(binding.ivProfileImage)
        binding.chatRoomDisplayImageView.setOnClickListener {
            // go back to user chat list
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.chat_room_app_bar, menu)
        return true
    }
}