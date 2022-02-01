package com.example.animefilms.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animefilms.model.AnimeFilmItem
import com.example.animefilms.repository.AnimeFilmRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeFilmViewModel
@Inject
constructor(private val repository: AnimeFilmRepo) : ViewModel() {

    private val _response = MutableLiveData<ArrayList<AnimeFilmItem>>()

    fun getResponses(): LiveData<ArrayList<AnimeFilmItem>> {
        viewModelScope.launch(Dispatchers.IO) {
            val films = repository.getAnimeFilm()
            _response.postValue(films.body())
        }
        return _response
    }
}