package com.of.astrojournal.auth.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.of.astrojournal.R
import com.of.astrojournal.auth.login.components.EmailTextField
import com.of.astrojournal.auth.login.components.ForgotPasswordText
import com.of.astrojournal.auth.login.components.LoginButton
import com.of.astrojournal.auth.login.components.PasswordTextField
import com.of.astrojournal.auth.login.components.RegisterButton
import com.of.astrojournal.auth.login.tooling.LoginScreenTestData
import com.of.astrojournal.designsystem.component.AstroJournalTopBar
import com.of.astrojournal.designsystem.component.ScreenTemplate
import com.of.astrojournal.designsystem.component.ScrollingColumn
import kotlinx.coroutines.flow.StateFlow

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onNavigateHome: () -> Unit,
) {
    LoginScreen(
        email = viewModel.email,
        password = viewModel.password,
        onEmailChange = viewModel::onEmailChange,
        onPasswordChange = viewModel::onPasswordChange,
        onForgotPasswordClick = {
        },
        onLoginClick = onNavigateHome,
        onRegisterClick = {
        },
    )
}

@Composable
internal fun LoginScreen(
    email: StateFlow<String>,
    password: StateFlow<String>,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onForgotPasswordClick: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
) {
    val description = stringResource(R.string.auth_semantic_login_screen)

    ScreenTemplate(
        description = description,
        topBar = { AstroJournalTopBar(title = stringResource(R.string.app_name)) },
    ) {
        ScrollingColumn {
            EmailTextField(email = email, onEmailChange = onEmailChange)
            PasswordTextField(password = password, onPasswordChange = onPasswordChange)
            ForgotPasswordText(onForgotPasswordClick)
            LoginButton(onLoginClick)
            RegisterButton(onRegisterClick)
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreenTestData()
}