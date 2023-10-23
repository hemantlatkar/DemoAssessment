package com.example.demoassessment.ui.home.repository

import com.example.demoAssesment.data.MoviesResponse
import com.example.demoassessment.data.MovieAppService
import com.example.demoassessment.domain.models.moviedetails.MovieDetails
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