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
fun VisibilityIconButton(isVisible: Boolean, onClick: () -> Unit) {
    val description = stringResource(R.string.designsystem_semantic_eye_icon_button)

    val painter = if (isVisible) {
        R.drawable.ic_visibility
    } else {
        R.drawable.ic_visibility_off
    }

    IconButton(
        onClick = onClick,
        modifier = Modifier.semantics { contentDescription = description }
    ) {
        Icon(
            painter = painterResource(painter), contentDescription = null
        )
    }
}