package com.solodev.gptchat.domain.repository

import com.solodev.gptchat.domain.model.Answer
import com.solodev.gptchat.domain.model.BaseModel
import com.solodev.gptchat.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun askQuestion(prevQuestion: List<Message>, question: String): BaseModel<Answer>

    suspend fun getMessages(): Flow<List<Message>>

    suspend fun addAnswer(answer: Message)

}