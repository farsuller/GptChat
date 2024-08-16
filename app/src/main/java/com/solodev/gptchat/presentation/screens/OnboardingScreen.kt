package com.solodev.gptchat.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.solodev.gptchat.R

@Composable
fun OnboardingScreen(
    continueButtonOnClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 28.dp, end = 28.dp, top = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.hello),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 23.sp
                    )
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = stringResource(id = R.string.onboarding_spiel),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall.copy(
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )
                )

                Image(
                    modifier = Modifier
                        .height(400.dp)
                        .padding(top = 84.dp)
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.onboarding_ai_chat),
                    contentDescription = ""
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 34.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                onClick = continueButtonOnClick
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.continue_button),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp
                    )
                )

                Image(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.AutoMirrored.Filled.Send,
                    colorFilter = ColorFilter.tint(color = Color.White),
                    contentDescription = ""
                )

            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreePreview() {
    OnboardingScreen(continueButtonOnClick = {})
}