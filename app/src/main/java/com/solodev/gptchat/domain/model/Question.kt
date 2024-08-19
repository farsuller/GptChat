package com.solodev.gptchat.domain.model

import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("model")
    val model:String = "gpt-3.5-turbo",
    @SerializedName("messages")
    val messages:List<Message>
)
