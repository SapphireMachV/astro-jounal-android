package com.of.astrojournal.designsystem.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.of.astrojournal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AstroJournalTopBar(title: String) {
    val description = stringResource(R.string.designsystem_semantic_top_bar)

    TopAppBar(
        modifier = Modifier.semantics { contentDescription = description },
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}