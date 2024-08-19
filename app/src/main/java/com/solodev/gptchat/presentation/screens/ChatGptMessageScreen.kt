package com.solodev.gptchat.presentation.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.solodev.gptchat.domain.model.fromUser
import com.solodev.gptchat.MainViewModel
import com.solodev.gptchat.presentation.components.ReceiverMessageItem
import com.solodev.gptchat.presentation.components.SenderMessageItem
import com.solodev.gptchat.presentation.components.ToolbarGpt
import com.solodev.gptchat.presentation.components.WriteTextField

@Composable
fun ChatGptMessageScreen(
    onBackClick: () -> Unit,
) {
    val viewModel: MainViewModel = viewModel()
    val messages by viewModel.messages.collectAsState()
    val loading by viewModel.loading.collectAsState()

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
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 10.dp, end = 10.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
                horizontalAlignment = Alignment.End
            ) {
                items(messages) { message ->
                    if (message.fromUser) {
                        SenderMessageItem(
                            modifier = Modifier.align(Alignment.End),
                            message = message.content
                        )
                    } else {
                        ReceiverMessageItem(message = message.content)
                    }
                }
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
                    if (input.isNotEmpty()) {
                        viewModel.askQuestion(question = input)
                        setInput("")
                    }
                }
            )
        }

}

@Preview
@Composable
fun MessageScreenPreview() {
    ChatGptMessageScreen(onBackClick = {})
}