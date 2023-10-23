package com.example.demoassessment.data

import com.example.demoAssesment.data.MoviesResponse
import com.example.demoassessment.domain.models.moviedetails.MovieDetails
import com.example.demoassessment.presentation.utils.APIConstants
import com.example.demoassessment.presentation.utils.ScreensConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAppService {

    @GET(APIConstants.POPULAR_MOVIE_PATH)
    suspend fun getPopularMovies(
        @Query(APIConstants.API_KEY_ARG) apiKey: String?
    ): Response<MoviesResponse>

    /*@GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String?): Response<MovieDetails>*/


    @GET(APIConstants.MOVIE_DETAILS_PATH)
    suspend fun getMovieDetails(
        @Path(APIConstants.MOVIE_ID_ARG) movieId: Int,
        @Query(APIConstants.API_KEY_ARG) apiKey: String?
    ): Response<MovieDetails>

}
