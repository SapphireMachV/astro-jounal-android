package com.of.astrojournal.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.of.astrojournal.ui.theme.AstroJournalTheme

@Composable
fun App() {
    val navController = rememberNavController()

    AstroJournalTheme {
        AppNavGraph(navController)
    }
}