package com.hellow.whatsappclone.ui.userScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellow.TestData
import com.hellow.whatsappclone.adaptor.UserListAdaptor
import com.hellow.whatsappclone.database.ChatDataBase
import com.hellow.whatsappclone.databinding.ActivityUserScreenBinding
import com.hellow.whatsappclone.repository.RepositoryImpl
import com.hellow.whatsappclone.ui.chatScreen.ChatListActivity
import timber.log.Timber

class UserScreen : AppCompatActivity() {

    lateinit var binding:ActivityUserScreenBinding
    private lateinit var viewModel:UserScreenViewModel
    private lateinit var userAdapter:UserListAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatRepository = RepositoryImpl(ChatDataBase(this)!!)
        val viewModelProviderFactory = UserScreenViewModelFactory(application, chatRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory )[UserScreenViewModel::class.java]

        setUpChatListData()
        setUpAppbar()
        viewModel.insert(TestData.user1)
        Timber.d("User1 added")
        viewModel.insert(TestData.user2)
        Timber.d("User2 added")
        viewModel.insert(TestData.user3)
        Timber.d("User3 added")
          viewModel.insert(TestData.user4)
        Timber.d("User4 added")


        viewModel.getUserList().observe(this) {
            Timber.d("all the users")
            if (it == null) {
                binding.userList.visibility = View.GONE
                binding.emptyListView.visibility = View.VISIBLE
            } else {
                if(it.isEmpty()){
                    binding.userList.visibility = View.GONE
                    binding.emptyListView.visibility = View.VISIBLE
                } else {
                    userAdapter.differ.submitList(it)
                    binding.userList.visibility = View.VISIBLE
                    binding.emptyListView.visibility = View.GONE
                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpChatListData() {
        userAdapter = UserListAdaptor()

        binding.userList.adapter = userAdapter
        binding.userList.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        binding.userList.setHasFixedSize(true)

        userAdapter.setOnItemClickListener {
            // go to the chat screen
            val intent = Intent(this,ChatListActivity::class.java)
            intent.putExtra("userProfile",it)
            startActivity(intent)
        }
    }

    private fun setUpAppbar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }
}