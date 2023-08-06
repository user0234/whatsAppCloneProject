package com.hellow

import com.hellow.whatsappclone.models.ChatType
import com.hellow.whatsappclone.models.UserItem

object TestData {

    val user1 = UserItem(
        "userId1",
        "samm",
        false,
        "https://cdn.pixabay.com/photo/2016/09/05/21/37/cat-1647775_1280.jpg",
        ChatType.Text,
        "This is just last message",
        true,
        false,
        "Tuesday"
    )

    val user2 = UserItem(
        "userId2",
        "tommy",
        false,
        "https://cdn.pixabay.com/photo/2017/11/14/13/06/kitty-2948404_1280.jpg",
        ChatType.Image,
        "Photo",
        false,
        false,
        "Monday"
    )

    val user3 = UserItem(
        "userId3",
        "yellowa",
        false,
        "https://cdn.pixabay.com/photo/2016/03/28/10/05/kitten-1285341_1280.jpg",
        ChatType.Audio,
        "0:10",
        true,
        true,
        "Yesterday"
    )

    val user4 = UserItem(
        "userId4",
        "mine",
        false,
        "https://cdn.pixabay.com/photo/2017/11/13/07/14/cats-eyes-2944820_1280.jpg",
        ChatType.Link,
        "https://en.wikipedia.org/wiki/Shades_of_gray",
        false,
        false,
        "Today"
    )

    val UsersList: List<UserItem> = listOf(user1, user2, user3, user4)
}