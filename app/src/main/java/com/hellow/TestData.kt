package com.hellow

import com.hellow.whatsappclone.models.ChatItem
import com.hellow.whatsappclone.models.ChatType
import com.hellow.whatsappclone.models.UserChatData
import com.hellow.whatsappclone.models.UserItem

object TestData {

    val user1 = UserItem(
        1,
        "samm",
        false,
        "https://cdn.pixabay.com/photo/2016/09/05/21/37/cat-1647775_1280.jpg",
        ChatType.TextSent,
        "This is just last message",
        true,
        false,
        "Tuesday"
    )

    val user2 = UserItem(
        2,
        "tommy",
        false,
        "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_1280.jpg",
        ChatType.ImageSent,
        "Photo",
        false,
        false,
        "Monday"
    )

    val user3 = UserItem(
        3,
        "yellowa",
        false,
        "https://cdn.pixabay.com/photo/2016/03/28/10/05/kitten-1285341_1280.jpg",
        ChatType.AudioSent,
        "0:10",
        true,
        true,
        "Yesterday"
    )

    val user4 = UserItem(
        4,
        "mine",
        false,
        "https://cdn.pixabay.com/photo/2017/11/13/07/14/cats-eyes-2944820_1280.jpg",
        ChatType.TextSent,
        "https://en.wikipedia.org/wiki/Shades_of_gray",
        false,
        false,
        "Today"
    )

    val UsersList: List<UserItem> = listOf(user1, user2, user3, user4)
    // user 1 chat
    private val chatListItem1User1 = ChatItem(1,ChatType.TextSent,"This is the first message",false,null,null,null,null,"1","1:40 am")
    private val chatListItem2User1 = ChatItem(2,ChatType.TextNotSent,"This is the first message",false,null,null,null,null,"1","1:50 am")
    private val chatListItem3User1 = ChatItem(3,ChatType.TextSent,"This is the second message",false,null,null,null,null,"1"," 2:10 am")
    private val chatListItem4User1 = ChatItem(4,ChatType.ImageSent,null,false,"https://images.unsplash.com/photo-1608848461950-0fe51dfc41cb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"1","2:10 am")
    private val chatListItem5User1 = ChatItem(5,ChatType.ImageSent,null,false,"https://images.unsplash.com/photo-1615678815958-5910c6811c25?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Nnx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"1","2:15 am")
    private val chatListItem6User1 = ChatItem(6,ChatType.TextSent,"Message after image sent",false,null,null,null,null,"1","2:25 am")
    private val chatListItem7User1 = ChatItem(7,ChatType.AudioSent,"ksjdfsdo.wav",false,null,"0:15",null,null,"1","2:27 am")
    private val chatListItem8User1 = ChatItem(8,ChatType.VideoNotSent,"thsi is sdf",false,"https://images.unsplash.com/photo-1571988840298-3b5301d5109b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"1","2:30 am")
    private val chatListItem9User1 = ChatItem(9,ChatType.TextSent,"ksjdfsdo",false,null,null,null,null,"1","2:33 am")

    // user 2 chat
    private val chatListItem1User2 = ChatItem(10,ChatType.TextSent,"This is the first message",false,null,null,null,null,"2","1:40 am")
    private val chatListItem2User2 = ChatItem(11,ChatType.TextNotSent,"This is the first message",false,null,null,null,null,"2","1:50 am")
    private val images:List<String> = listOf("https://images.unsplash.com/photo-1586289883499-f11d28aaf52f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8OXx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",
        "https://images.unsplash.com/photo-1608032364895-0da67af36cd2?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTF8fHxlbnwwfHx8fHw%3D&auto=format&fit=crop&w=600&q=60",
        "https://images.unsplash.com/photo-1506755855567-92ff770e8d00?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8OHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60"
        ,"https://images.unsplash.com/photo-1599889959407-598566c6e1f1?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTd8fHxlbnwwfHx8fHw%3D&auto=format&fit=crop&w=600&q=60")

    private val chatListItem3User2 = ChatItem(12,ChatType.MultiImageSent,null,false,null,null,
        images,null,"2"," 2:10 am")

    private val chatListItem4User2 = ChatItem(13,ChatType.ImageSent,null,false,"https://images.unsplash.com/photo-1608848461950-0fe51dfc41cb?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Mnx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"2","2:10 am")
    private val chatListItem5User2 = ChatItem(14,ChatType.ImageSent,null,false,"https://images.unsplash.com/photo-1615678815958-5910c6811c25?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8Nnx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"2","2:15 am")
    private val chatListItem6User2 = ChatItem(15,ChatType.TextSent,"Message after image sent",false,null,null,null,null,"2","2:25 am")
    private val chatListItem7User2 = ChatItem(16,ChatType.AudioSent,"ksjdfsdo.wav",false,null,"0:15",null,null,"2","2:27 am")
    private val chatListItem8User2 = ChatItem(17,ChatType.VideoNotSent,"thsi is sdf",false,"https://images.unsplash.com/photo-1571988840298-3b5301d5109b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=600&q=60",null,null,null,"2","2:30 am")
    private val chatListItem9User2 = ChatItem(18,ChatType.TextSent,"ksjdfsdo",false,null,null,null,null,"2","2:33 am")


    private val userChatList1:List<ChatItem> = listOf(chatListItem1User1,chatListItem2User1,chatListItem3User1,chatListItem4User1,chatListItem5User1,chatListItem6User1,chatListItem7User1,chatListItem8User1,chatListItem9User1)
    private val userChatList2:List<ChatItem> = listOf(chatListItem1User2,chatListItem2User2,chatListItem3User2,chatListItem4User2,chatListItem5User2,chatListItem6User2,chatListItem7User2,chatListItem8User2,chatListItem9User2)

    private val userChatData1:UserChatData = UserChatData(1,userChatList1,"samm","https://cdn.pixabay.com/photo/2016/09/05/21/37/cat-1647775_1280.jpg")

    private val userChatData2:UserChatData = UserChatData(2,userChatList2,"tommy","https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_1280.jpg")

    private val userChatData3:UserChatData = UserChatData(3,userChatList2,"yellowa","https://cdn.pixabay.com/photo/2016/03/28/10/05/kitten-1285341_1280.jpg")

    private val userChatData4:UserChatData = UserChatData(4,userChatList2,"mine","https://cdn.pixabay.com/photo/2017/11/13/07/14/cats-eyes-2944820_1280.jpg")

    private val allUserChatData: List<UserChatData> = listOf<UserChatData>(userChatData1,userChatData2,userChatData3,userChatData4)

    fun userData(id:Int):UserChatData{

        return allUserChatData[id-1]
    }

}