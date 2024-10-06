package com.of.astrojournal.auth.login.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.of.astrojournal.R
import com.of.astrojournal.designsystem.component.VisibilityIconButton
import kotlinx.coroutines.flow.StateFlow

@Composable
internal fun EmailTextField(email: StateFlow<String>, onEmailChange: (String) -> Unit) {
    val emailValue by email.collectAsStateWithLifecycle()

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailValue,
        label = { Text(stringResource(R.string.auth_login_textfield_email)) },
        onValueChange = onEmailChange
    )
}

@Composable
internal fun PasswordTextField(
    password: StateFlow<String>,
    onPasswordChange: (String) -> Unit,
) {
    val passwordValue by password.collectAsStateWithLifecycle()

    var usePasswordFilter by remember { mutableStateOf(true) }

    val visualTransformation = if (usePasswordFilter) {
        PasswordVisualTransformation()
    } else {
        VisualTransformation.None
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordValue,
        label = { Text(stringResource(R.string.auth_login_textfield_password)) },
        visualTransformation = visualTransformation,
        onValueChange = onPasswordChange,
        trailingIcon = {
            VisibilityIconButton(usePasswordFilter) {
                usePasswordFilter = usePasswordFilter.not()
            }
        }
    )
}