package com.solodev.gptchat.presentation.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.solodev.gptchat.presentation.components.ToolbarGpt
import com.solodev.gptchat.presentation.components.WriteTextField

@Composable
fun ChatGptMessageScreen(
    onBackClick: () -> Unit,
) {
    val (input, setInput) = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .navigationBarsPadding()
                .animateContentSize()
                .background(Color.White)
        ) {
            ToolbarGpt(onBackClick = onBackClick)

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End
            ) {
                // Chat messages here
            }

            WriteTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                value = input,
                onValueChange = { value ->
                    setInput(value)
                },
                onSendClick = {

                }
            )
        }

}

@Preview
@Composable
fun MessageScreenPreview() {
    ChatGptMessageScreen(onBackClick = {})
}