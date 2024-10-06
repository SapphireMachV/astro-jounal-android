package com.of.astrojournal.designsystem.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ScrollingColumn(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    contentPadding: PaddingValues = PaddingValues(16.dp),
    verticalSpacing: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
   Column(
       modifier = modifier
           .fillMaxSize()
           .verticalScroll(scrollState)
           .padding(contentPadding),
       verticalArrangement = Arrangement.spacedBy(verticalSpacing),
       content = content
   )
}