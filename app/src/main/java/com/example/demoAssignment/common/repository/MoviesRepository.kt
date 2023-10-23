package com.example.demoassignment.ui.home.repository

import com.example.demoAssignment.data.MoviesResponse
import com.example.demoassignment.data.MovieAppService
import com.example.demoassignment.domain.models.moviedetails.MovieDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MoviesRepository @Inject constructor(private val movieAppService: MovieAppService) {

    suspend fun fetchPopular(apikey: String): Response<MoviesResponse> = withContext(
        Dispatchers.IO) {
        val popular = movieAppService.getPopularMovies(apikey)
        popular
    }

    suspend fun getMovieDetails(apikey: String,movieId : Int): Response<MovieDetails> = withContext(
        Dispatchers.IO) {
        val popular = movieAppService.getMovieDetails(movieId,apikey)
        popular
    }

}