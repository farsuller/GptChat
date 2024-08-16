package com.solodev.gptchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.solodev.gptchat.navigation.ChatGptMessageRoute
import com.solodev.gptchat.navigation.OnboardingRoute
import com.solodev.gptchat.presentation.screens.ChatGptMessageScreen
import com.solodev.gptchat.presentation.screens.OnboardingScreen
import com.solodev.gptchat.ui.theme.GptChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GptChatTheme(
                dynamicColor = false
            ) {
                val navController = rememberNavController()

                Scaffold { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = OnboardingRoute,
                        modifier = Modifier.padding(
                            top = innerPadding.calculateTopPadding(),
                            )) {
                        composable<OnboardingRoute>{
                            OnboardingScreen(
                                continueButtonOnClick = {
                                    navController.navigate(ChatGptMessageRoute)
                                },
                            )
                        }

                        composable<ChatGptMessageRoute>{
                            ChatGptMessageScreen(
                                onBackClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }

            }
        }
    }
}



