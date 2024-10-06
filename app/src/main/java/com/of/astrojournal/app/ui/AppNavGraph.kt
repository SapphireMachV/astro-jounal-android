package com.of.astrojournal.app.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.of.astrojournal.auth.login.LoginScreen
import com.of.astrojournal.home.HomeScreen

private object AppRoutes {

    const val APP = "app"
    const val LAUNCH = "launch"

}

object AppDestinations {

    object App {
        const val HOME = "${AppRoutes.APP}/home"
    }

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
                LoginScreen(
                    viewModel = hiltViewModel(),
                    onNavigateHome = navController::navigateHome
                )
            }
        }

        navigation(startDestination = AppDestinations.App.HOME, route = AppRoutes.APP) {
            composable(AppDestinations.App.HOME) {
                HomeScreen(viewModel = hiltViewModel())
            }
        }
    }
}

fun NavController.navigateHome() {
    navigate(AppDestinations.App.HOME) {
        popUpTo(AppDestinations.Launch.AUTH) {
            inclusive = true
        }
    }
}