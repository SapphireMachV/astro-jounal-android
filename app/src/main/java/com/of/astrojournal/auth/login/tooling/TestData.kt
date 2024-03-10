package com.of.astrojournal.auth.login.tooling

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.of.astrojournal.auth.login.LoginScreen

@Composable
fun LoginScreenTestData() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LoginScreen(
        email = email,
        password = password,
        onEmailChange = { email = it },
        onPasswordChange = { password = it },
        onForgotPasswordClick = {},
        onLoginClick = {},
        onRegisterClick = {}
    )
}