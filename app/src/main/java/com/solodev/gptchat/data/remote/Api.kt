package com.solodev.gptchat.data.remote

import com.solodev.gptchat.BuildConfig.API_KEY
import com.solodev.gptchat.domain.model.Answer
import com.solodev.gptchat.domain.model.Question
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST



interface Api {

    @POST("completions")
    @Headers("Authorization: Bearer $API_KEY", "Content-Type: application/json")
    suspend fun askQuestion(
        @Body question: Question
    ): Response<Answer>

}