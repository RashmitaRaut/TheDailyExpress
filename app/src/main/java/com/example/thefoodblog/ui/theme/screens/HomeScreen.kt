package com.example.thefoodblog.ui.theme.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.thefoodblog.R
import com.example.thefoodblog.components.BottomNavigationBarComponent
import com.example.thefoodblog.components.TopAppbarComponent
import com.example.thefoodblog.data.Article
import com.example.thefoodblog.model.fetchNewsHeadlinesFromApi


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val newsState = remember { mutableStateOf(emptyList<Article>()) }

    LaunchedEffect(Unit) {
        val newsArticles = fetchNewsHeadlinesFromApi()
        newsState.value = newsArticles
    }

    Scaffold(
        topBar = { TopAppbarComponent() },
        bottomBar = { BottomNavigationBarComponent(navController = navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(15.dp)

        ) {

            Text(
                text = "Top Headlines: ",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.padding(start = 12.dp)

            )
            Spacer(modifier = Modifier.height(10.dp))

            // Scrollable list
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {

                itemsIndexed(newsState.value) { index, article ->

                    Surface(
                        modifier = Modifier
                            .padding(10.dp)
                            .width(320.dp)
                            .height(300.dp),
                        color = colorResource(id = R.color.Gold_sand),
                        shape = RoundedCornerShape(8.dp),

                        ) {

                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .width(250.dp)
                                .height(300.dp)
                                .padding(vertical = 8.dp),

                            ) {
                            Column(Modifier.fillMaxWidth()) {
                                Image(
                                    painter = rememberImagePainter(article.urlToImage),
                                    contentDescription = "News Image",
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .clip(shape = RoundedCornerShape(8.dp))
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Text(text = article.title, fontWeight = FontWeight.Bold)
                                    Text(text = article.author, color = Color.Gray)
                                }

                            }
                        }
                    }
                }
            }

        }
    }
}



