package com.adl.testmandiri.services

import com.adl.testmandiri.model.THMovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface Movie {
    @GET("3/genre/movie/list?api_key=9418621ada16c00a584f7238bc0748f7")
    fun getMGenreList(): Call<THMovieResponse>

    @GET("/3/movie/popular?api_key=9418621ada16c00a584f7238bc0748f7")
    fun getMovieList(): Call<THMovieResponse>

}