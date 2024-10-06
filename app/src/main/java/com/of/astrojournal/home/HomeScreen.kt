package com.of.astrojournal.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.of.astrojournal.R
import com.of.astrojournal.designsystem.component.AstroJournalTopBar
import com.of.astrojournal.designsystem.component.ScreenTemplate
import com.of.astrojournal.designsystem.component.ScrollingColumn
import kotlinx.coroutines.flow.StateFlow

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreen(viewModel.isReady)
}

@Composable
internal fun HomeScreen(isReady: StateFlow<Boolean>) {
    val description = stringResource(R.string.home_semantic_home_screen)

    ScreenTemplate(
        description = description,
        isReady = isReady,
        topBar = { AstroJournalTopBar(title = stringResource(R.string.home_title)) }
    ) {
        ScrollingColumn {
            Text("Welcome to the home screen :)")
        }
    }
}