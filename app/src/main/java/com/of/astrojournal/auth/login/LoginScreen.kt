package com.of.astrojournal.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.of.astrojournal.R
import com.of.astrojournal.auth.login.components.EmailTextField
import com.of.astrojournal.auth.login.components.ForgotPasswordText
import com.of.astrojournal.auth.login.components.LoginButton
import com.of.astrojournal.auth.login.components.PasswordTextField
import com.of.astrojournal.auth.login.components.RegisterButton
import com.of.astrojournal.designsystem.component.AstroJournalTopBar

@Composable
internal fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    val description = stringResource(R.string.auth_semantic_login_screen)

    Scaffold(
        modifier = Modifier.semantics { contentDescription = description },
        topBar = { AstroJournalTopBar(title = stringResource(R.string.app_name)) }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var usePasswordFilter by remember { mutableStateOf(true) }

            val passwordVisualTransformation = if (usePasswordFilter) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                ),
            ) {
                EmailTextField(email = email) { email = it }
                PasswordTextField(
                    password = password,
                    visualTransformation = passwordVisualTransformation,
                    onPasswordChange = { password = it }
                ) {
                    usePasswordFilter = !usePasswordFilter
                }
                ForgotPasswordText(onForgotPasswordClick)
                LoginButton(onLoginClick)
                RegisterButton(onRegisterClick)
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        onForgotPasswordClick = {},
        onLoginClick = {},
        onRegisterClick = {}
    )
}