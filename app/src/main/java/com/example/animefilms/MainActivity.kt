package com.example.animefilms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.animefilms.ui.theme.AnimeFilmsTheme
import com.example.animefilms.ui.theme.ReciveData
import com.example.animefilms.viewmodel.AnimeFilmViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: AnimeFilmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeFilmsTheme {
                // A surface container using the 'background' color from the theme
                ReciveData(viewModel)
            }
        }
    }
}
