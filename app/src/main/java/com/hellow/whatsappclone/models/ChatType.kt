package com.hellow.whatsappclone.models

enum class ChatType {
    TextSent,
    TextNotSent, // when only text is sent from any sides
    ImageSent,
    ImageNotSent,// when a single image or unto 3 images are sent by same user
    MultiImageSent,
    MultiImageNotSent,// when number of images sent by single user exceeds 3
    AudioSent, // Audio sent by the user
    AudioNotSent,
    VideoSent,// Video is sent by the user
    VideoNotSent
}