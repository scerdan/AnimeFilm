package com.example.animefilms.repository

import com.example.animefilms.data.ApiService
import com.example.animefilms.model.AnimeFilm
import retrofit2.Response
import javax.inject.Inject

class AnimeFilmRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun getAnimeFilm(): Response<AnimeFilm> {
        return apiService.getListFilms()
    }

}