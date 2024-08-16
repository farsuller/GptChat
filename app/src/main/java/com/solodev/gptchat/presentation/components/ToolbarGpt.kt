package com.solodev.gptchat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.solodev.gptchat.R
import com.solodev.gptchat.utils.clickableWithoutRipple

@Composable
fun ToolbarGpt(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color.White,
        shadowElevation = 4.dp
    ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(horizontal = 5.dp)
                    .padding(start = 5.dp, bottom = 5.dp, top = 5.dp),
            ) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickableWithoutRipple { onBackClick() },
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(40.dp)
                        .padding(start = 12.dp),
                    painter = painterResource(id = R.drawable.chatgpt_icon),
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.gpt),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        )
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Row {
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .size(6.dp)
                                .background(
                                    color = MaterialTheme.colorScheme.tertiary,
                                    shape = CircleShape
                                )
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = stringResource(id = R.string.gpt_online),
                            color = MaterialTheme.colorScheme.tertiary,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Medium,
                                fontSize = 12.sp
                            )
                        )
                    }
                }
            }

    }
}

@Preview
@Composable
fun ToolbarMessageGptPreview() {
    ToolbarGpt(onBackClick = {})
}