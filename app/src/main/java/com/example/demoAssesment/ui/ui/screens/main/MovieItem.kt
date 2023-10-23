package com.example.demoassessment.presentation.ui.screens.main

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.demoAssesment.data.Movie
import com.example.demoassessment.presentation.navigation.NavRoute
import com.example.demoassessment.presentation.utils.APIConstants.MOVIEDB_BASE_IMAGE_URL
import java.util.*

@Composable
fun MovieItem(navController: NavController, item: Movie) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(2.dp)
            .clickable {
                navController.navigate(NavRoute.DetailsMovie.route + "/${item.id}")
            },
        border = BorderStroke(2.dp, Color.Blue)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(0.dp, 500.dp)
                .padding(vertical = 8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(300.dp),
                painter = rememberAsyncImagePainter(
                    MOVIEDB_BASE_IMAGE_URL + item.posterPath
                ),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = item.title!!.uppercase(Locale.getDefault()),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}