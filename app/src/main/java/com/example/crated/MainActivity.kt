package com.example.crated

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.crated.ui.login.LoginPage
import com.example.crated.ui.login.SignupPage
import com.example.crated.ui.theme.CratedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CratedTheme {
                CratedApp()
            }
        }
    }
}

@Composable
fun CratedApp() {
    var currentScreen by rememberSaveable { mutableStateOf(AuthScreen.Login) }

    when (currentScreen) {
        AuthScreen.Login -> LoginPage(
            onNavigateToSignup = { currentScreen = AuthScreen.Signup }
        )

        AuthScreen.Signup -> SignupPage(
            onNavigateToLogin = { currentScreen = AuthScreen.Login }
        )
    }
}

private enum class AuthScreen {
    Login,
    Signup
}

@Preview(showBackground = true)
@Composable
fun CratedAppPreview() {
    CratedTheme {
        CratedApp()
    }
}
