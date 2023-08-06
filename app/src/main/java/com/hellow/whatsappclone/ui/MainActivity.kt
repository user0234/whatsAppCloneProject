package com.hellow.whatsappclone.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hellow.whatsappclone.databinding.ActivityMainBinding
import com.hellow.whatsappclone.ui.userScreen.UserScreen
import timber.log.Timber


// Splash Screen activity to show the splash screen logo and button to go to chat



class MainActivity : AppCompatActivity() {

     lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())


        binding.fbShowChat.setOnClickListener {
            // go to the chat screen
           Timber.d("fb clicked ")
            val intent = Intent(this,UserScreen::class.java)
            startActivity(intent)
        }
    }
}