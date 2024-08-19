package com.solodev.gptchat.domain.model

import com.google.gson.annotations.SerializedName

data class Answer(
    val id: String,
    @SerializedName("object")
    val obj: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>,
    val usage: Usage
)



