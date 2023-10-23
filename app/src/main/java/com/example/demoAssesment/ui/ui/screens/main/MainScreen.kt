@file:OptIn(ExperimentalCoilApi::class)

package com.example.demoassessment.presentation.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import androidx.compose.runtime.*

@Composable
fun MainScreen(navController: NavController) {
    val mViewModel = hiltViewModel<HomeViewModel>()

    val listMoviesPopular = mViewModel.listMoviesPopular.collectAsState().value

    LaunchedEffect(key1 = Unit, block = {
        mViewModel.getListMoviesPopular()
    })

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        content = { padding ->
            Column(){
                TopAppBar(
                    title = { Text(text = "Assessment") }
                )
                LazyColumn(
                    modifier = Modifier
                        .padding(padding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    listMoviesPopular.forEachIndexed { index, movie ->
                        items(index) {
                            MovieItem(navController = navController, item = movie)
                        }
                    }
                }
            }
        })
}