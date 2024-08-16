package com.solodev.gptchat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.solodev.gptchat.ui.theme.GptChatTheme
import com.solodev.gptchat.utils.clickableWithoutRipple

@Composable
fun WriteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    onSendClick: () -> Unit
) {

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(7.dp))
            .background(Color(0xFFDED1F7))
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            decorationBox = { innerTextField ->
                innerTextField()
            },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.Send,  // Example icon
            contentDescription = "Send",
            modifier = Modifier.clickableWithoutRipple {
                onSendClick()
            },
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTextField() {

    GptChatTheme(dynamicColor = false) {
        WriteTextField(
            value = "",
            onValueChange = {},
            onSendClick = {}
            )
    }

}
