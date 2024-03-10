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
import androidx.compose.runtime.collectAsState
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
import com.of.astrojournal.auth.login.tooling.LoginScreenTestData
import com.of.astrojournal.designsystem.component.AstroJournalTopBar

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()

    LoginScreen(
        email = email,
        password = password,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onForgotPasswordClick = {
        },
        onLoginClick = {
        },
        onRegisterClick = {
        }
    )

}

@Composable
internal fun LoginScreen(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
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
                EmailTextField(email = email, onEmailChange = onEmailChange)
                PasswordTextField(
                    password = password,
                    visualTransformation = passwordVisualTransformation,
                    onPasswordChange = onPasswordChange
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
    LoginScreenTestData()
}