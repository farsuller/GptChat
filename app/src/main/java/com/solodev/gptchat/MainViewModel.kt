package com.solodev.gptchat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.solodev.gptchat.data.local.AnswerEntity
import com.solodev.gptchat.data.local.AppDatabase
import com.solodev.gptchat.domain.model.BaseModel
import com.solodev.gptchat.domain.model.Message
import com.solodev.gptchat.domain.repository.Repository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel(), KoinComponent {

    private val database: AppDatabase by inject()
    private val repository: Repository by inject()

    private val _messages: MutableStateFlow<List<Message>> = MutableStateFlow(emptyList())
    val messages = _messages.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    init {

        viewModelScope.launch {
            repository.getMessages().collect { data ->
                _messages.update { data }
            }
        }

    }

    fun askQuestion(question: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                database.answerDao().addAnswer(
                    answerEntity = AnswerEntity(
                        role = "user",
                        content = question
                    )
                )
            }
            _loading.update { true }
            repository.askQuestion(
                prevQuestion = messages.value,
                question = question
            ).also { baseModel ->
                _loading.update { false }
                when (baseModel) {
                    is BaseModel.Success -> {
                        withContext(Dispatchers.IO) {
                            database.answerDao().addAnswer(answerEntity = AnswerEntity(
                                role = "assistant",
                                content = baseModel.data.choices.first().message.content
                            )
                            )
                        }
                    }

                    is  BaseModel.Error -> {
                        println("Something wrong : ${baseModel.error}")
                    }

                    else -> {}
                }
            }
        }
    }

}