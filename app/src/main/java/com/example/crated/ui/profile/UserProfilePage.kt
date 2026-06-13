package com.example.crated.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.crated.ui.common.UserProfileTopBar
import com.example.crated.ui.theme.CratedTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserProfilePage(
    username: String,
    onBackClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            UserProfileTopBar(
                username = username,
                onBackClick = onBackClick,
                onSettingsClick = onSettingsClick
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserProfilePagePreview() {
    CratedTheme {
        UserProfilePage(username = "janheinz")
    }
}
