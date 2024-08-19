package com.solodev.gptchat.domain.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("role")
    val role:String,
    @SerializedName("content")
    val content:String
)

val Message.fromUser:Boolean get() {
    return role == "user"
}
