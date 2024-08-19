package com.solodev.gptchat.data.repository

import com.solodev.gptchat.data.local.AnswerDao
import com.solodev.gptchat.data.local.AnswerEntity
import com.solodev.gptchat.data.remote.Api
import com.solodev.gptchat.domain.model.Answer
import com.solodev.gptchat.domain.model.BaseModel
import com.solodev.gptchat.domain.model.Message
import com.solodev.gptchat.domain.model.Question
import com.solodev.gptchat.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RepositoryImpl(private val api: Api, private val dao: AnswerDao) : Repository {

    override suspend fun askQuestion(
        prevQuestion: List<Message>,
        question: String
    ): BaseModel<Answer> {
        try {
            api.askQuestion(
                question = Question(
                    messages = prevQuestion + Message(
                        role = "user",
                        content = question
                    )
                )
            ).also { response ->
                return if (response.isSuccessful) {
                    BaseModel.Success(data = response.body()!!)
                } else {
                    BaseModel.Error(response.errorBody()?.string().toString())
                }
            }
        } catch (e: Exception) {
            return BaseModel.Error(e.message.toString())
        }
    }

    override suspend fun getMessages(): Flow<List<Message>> {
        return dao.getAnswer().map { value ->
            value.map { entity ->
                Message(role = entity.role, content = entity.content)
            }
        }
    }

    override suspend fun addAnswer(answer: Message) {
        dao.addAnswer(AnswerEntity(role = answer.role, content = answer.content))
    }
}