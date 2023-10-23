package com.example.demoassessment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demoassessment.presentation.ui.screens.detailsmovie.DetailsMovieScreen
import com.example.demoassessment.presentation.ui.screens.main.MainScreen
import com.example.demoassessment.presentation.ui.screens.splash.SplashScreen
import com.example.demoassessment.presentation.utils.APIConstants
import com.example.demoassessment.presentation.utils.ScreensConstants
import com.example.demoassessment.presentation.utils.StringsConstants.EMPTY_STRING

@Composable
fun SetupNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash.route
    ) {
        composable(route = NavRoute.Splash.route) {
            SplashScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.Main.route) {
            MainScreen(
                navController = navController
            )
        }
        composable(route = NavRoute.DetailsMovie.route + "/{${APIConstants.MOVIE_ID_ARG}}") { backStackEntry ->
            DetailsMovieScreen(
                navController = navController,
                movieId = backStackEntry.arguments?.getString(APIConstants.MOVIE_ID_ARG) ?: EMPTY_STRING)
        }
    }
}