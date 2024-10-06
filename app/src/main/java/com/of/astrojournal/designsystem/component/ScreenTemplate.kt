package com.of.astrojournal.designsystem.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ScreenTemplate(
    modifier: Modifier = Modifier,
    description: String,
    isReady: StateFlow<Boolean> = MutableStateFlow(true),
    topBar: @Composable () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    val isReadyValue by isReady.collectAsStateWithLifecycle()

    Scaffold(
        modifier = modifier.semantics { contentDescription = description },
        topBar = topBar,
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            if (isReadyValue) {
                content()
            }
        }
    }
}