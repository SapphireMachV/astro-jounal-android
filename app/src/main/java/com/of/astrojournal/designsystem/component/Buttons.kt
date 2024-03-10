package com.of.astrojournal.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.of.astrojournal.R

@Composable
fun EyeIconButton(onClick: () -> Unit) {
    val description = stringResource(R.string.designsystem_semantic_eye_icon_button)

    IconButton(
        onClick = onClick,
        modifier = Modifier.semantics { contentDescription = description }
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_eye), contentDescription = null
        )
    }
}