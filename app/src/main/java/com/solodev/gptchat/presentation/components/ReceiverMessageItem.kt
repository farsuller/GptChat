package com.solodev.gptchat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.solodev.gptchat.R
import com.solodev.gptchat.ui.theme.GptChatTheme

@Composable
fun ReceiverMessageItem(
    modifier: Modifier = Modifier,
    message: String = ""
) {
    Row(
        modifier = modifier
    ) {
        Surface(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Bottom),
            shape = CircleShape,
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 6.dp)
                    .size(18.dp),
                painter = painterResource(id = R.drawable.chatgpt_icon),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Surface(
            modifier = Modifier
                .wrapContentSize()
                .padding(bottom = 24.dp),
            shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp, bottomEnd = 25.dp),
            color = MaterialTheme.colorScheme.tertiary
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 14.dp),
                text = message,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                style = MaterialTheme.typography.labelLarge.copy(color = Color(0xFFE7E7E7))
            )
        }
    }
}

@Preview
@Composable
fun ReceiverMessageItemPreview() {

    GptChatTheme (dynamicColor = false){
        ReceiverMessageItem(
            modifier = Modifier.wrapContentSize(),
            message = "Hello, how are you?"
        )
    }

}