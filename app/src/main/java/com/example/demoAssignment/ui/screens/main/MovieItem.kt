package com.example.demoassignment.presentation.ui.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.demoAssignment.data.Movie
import com.example.demoassignment.presentation.navigation.NavRoute
import com.example.demoassignment.presentation.utils.APIConstants.MOVIEDB_BASE_IMAGE_URL
import java.util.*

@Composable
fun MovieItem(navController: NavController, item: Movie) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp) // Set the specific height
            .padding(5.dp)
            .clickable {
                navController.navigate(NavRoute.DetailsMovie.route + "/${item.id}")
            },
        elevation = 4.dp,
        backgroundColor = Color.White,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(270.dp) // Adjust the image height
                    .clip(MaterialTheme.shapes.medium),
                painter = rememberAsyncImagePainter(
                    MOVIEDB_BASE_IMAGE_URL + item.posterPath
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                text = "Movie: ${item.title!!.uppercase(Locale.getDefault())}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
        }
    }
}
