package com.solodev.gptchat

import android.app.Application
import androidx.room.Room
import com.solodev.gptchat.data.local.AppDatabase
import com.solodev.gptchat.data.remote.Api
import com.solodev.gptchat.data.repository.RepositoryImpl
import com.solodev.gptchat.domain.repository.Repository
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatGptApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(module {
                single {
                    Retrofit.Builder()
                        .baseUrl("https://api.openai.com/v1/chat/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                single {
                    val retrofit: Retrofit = get()
                    retrofit.create(Api::class.java)
                }
                single {
                    Room.databaseBuilder(
                        this@ChatGptApp,
                        AppDatabase::class.java,
                        "db_gpt_chat"
                    ).build()
                }
                single {
                    val api: Api = get()
                    val database: AppDatabase = get()

                    RepositoryImpl(api = api, dao = database.answerDao())

                } bind Repository::class
            })
        }
    }
}