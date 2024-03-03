package com.of.astrojournal.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

private object AppRoutes {

    const val LAUNCH = "launch"

}

object AppDestinations {

    object Launch {
        const val AUTH = "${AppRoutes.LAUNCH}/auth"
    }

}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppRoutes.LAUNCH
) {
    NavHost(navController = navController, startDestination = startDestination) {
        navigation(startDestination = AppDestinations.Launch.AUTH, route = AppRoutes.LAUNCH) {
            composable(AppDestinations.Launch.AUTH) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("Hello Android!")
                }
            }
        }
    }
}