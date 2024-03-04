package com.of.astrojournal.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.of.feature.auth.login.LoginScreen

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
                LoginScreen()
            }
        }
    }
}