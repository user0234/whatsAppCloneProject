package com.hellow.whatsappclone.models

import java.io.Serializable

data class UserChatData(
    val id:Int,
    val data:List<ChatItem>,
    val name:String,
    val profileUrl:String,
):Serializable
