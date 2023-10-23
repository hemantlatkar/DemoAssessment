package com.example.demoassignment.presentation.ui.screens.detailsmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoassignment.BuildConfig
import com.example.demoassignment.ui.home.repository.MoviesRepository
import com.example.demoassignment.domain.models.moviedetails.BelongsToCollection
import com.example.demoassignment.domain.models.moviedetails.MovieDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsMovieViewModel @Inject constructor(private val moviesRepository: MoviesRepository)
    : ViewModel() {

    private val _movieDetails = MutableStateFlow(movieDetailsBase())
    val movieDetails = _movieDetails.asStateFlow()

    fun getMovieDetailsById(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
       val response = moviesRepository.getMovieDetails(BuildConfig.API_KEY,movieId = movieId)
            if (response.isSuccessful) {
                _movieDetails.emit(response.body()!!)
            } else {
            }
        }
    }

    private fun movieDetailsBase(): MovieDetails {
        return MovieDetails(
            adult = false,
            backdrop_path = "",
            belongs_to_collection = BelongsToCollection(
                backdrop_path = "", id = 0, name = "", poster_path = ""
            ),
            budget = 0,
            genreMS = listOf(),
            genres = listOf(),
            homepage = "",
            id = 0,
            imdb_id = "",
            original_language = "",
            original_title = "",
            overview = "",
            popularity = 0.0,
            poster_path = "",
            production_companies = listOf(),
            production_countries = listOf(),
            release_date = "",
            revenue = 0,
            runtime = 0,
            spoken_languages = listOf(),
            status = "",
            tagline = "",
            title = "",
            video = false,
            vote_average = 0.0,
            vote_count = 0
        )
    }
}