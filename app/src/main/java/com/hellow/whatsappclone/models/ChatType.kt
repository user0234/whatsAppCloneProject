package com.hellow.whatsappclone.models

enum class ChatType {
    Text,// when only text is sent from any sides
    Image,// when a single image or unto 3 images are sent by same user
    MultiImage, // when number of images sent by single user exceeds 3
    Audio, // Audio sent by the user
    Data, // non Supported data is sent
    Link, // link is sent by the user as text
    Video,// Video is sent by the user
}