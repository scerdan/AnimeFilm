package com.example.animefilms.data

import com.example.animefilms.model.AnimeFilm
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("films")
    suspend fun getListFilms(): Response<AnimeFilm>
}