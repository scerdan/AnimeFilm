package com.example.animefilms.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.animefilms.model.AnimeFilmItem
import com.example.animefilms.viewmodel.AnimeFilmViewModel

@Composable
fun ReciveData(
    ivm: AnimeFilmViewModel = hiltViewModel()
) {
    val tit by ivm.getResponses().observeAsState()
    tit?.let { AnimeListScreen(it) }
}

@ExperimentalCoilApi
@Composable
fun AnimeListScreen(tit: ArrayList<AnimeFilmItem>) {
    LazyColumn() {
        items(tit) { rta ->
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable {
                    },
            ) {
                Column {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f),
                        painter = rememberImagePainter(rta.movie_banner),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(modifier = Modifier.fillMaxWidth(1f))

                    Column(Modifier.padding(8.dp)) {
                        Text(rta.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(rta.director ?: "", maxLines = 3)
                    }
                }

            }
        }
    }
}