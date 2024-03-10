package com.of.astrojournal.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.of.astrojournal.designsystem.theme.AstroJournalTheme

@Composable
fun App() {
    val navController = rememberNavController()

    AstroJournalTheme {
        AppNavGraph(navController)
    }
}