package com.of.astrojournal.auth.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import com.of.astrojournal.R
import com.of.astrojournal.designsystem.component.EyeIconButton

@Composable
internal fun EmailTextField(email: String, onEmailChange: (String) -> Unit) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        label = { Text(stringResource(R.string.auth_login_textfield_email)) },
        onValueChange = onEmailChange
    )
}

@Composable
internal fun PasswordTextField(
    password: String,
    visualTransformation: VisualTransformation,
    onPasswordChange: (String) -> Unit,
    onShowPasswordClick: () -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        label = { Text(stringResource(R.string.auth_login_textfield_password)) },
        visualTransformation = visualTransformation,
        onValueChange = onPasswordChange,
        trailingIcon = { EyeIconButton(onShowPasswordClick) }
    )
}