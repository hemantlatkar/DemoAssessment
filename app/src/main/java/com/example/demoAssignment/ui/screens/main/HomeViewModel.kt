package com.example.demoassignment.presentation.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoAssignment.data.Movie
import com.example.demoassignment.BuildConfig
import com.example.demoassignment.ui.home.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val moviesRepository: MoviesRepository)
    : ViewModel() {

    private val _loadingListMoviesPopular = MutableStateFlow<Boolean>(false)

    private val _listMoviesPopular = MutableStateFlow<List<Movie>>(listOf())
    val listMoviesPopular = _listMoviesPopular.asStateFlow()

    fun getListMoviesPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = moviesRepository.fetchPopular(BuildConfig.API_KEY)
            if (response.isSuccessful) {
                _loadingListMoviesPopular.emit(false)
                _listMoviesPopular.emit(response.body()!!.movies!!)
            } else {
                _loadingListMoviesPopular.emit(false)
            }
        }
    }
}