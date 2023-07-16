package com.example.thefoodblog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thefoodblog.components.Screen
import com.example.thefoodblog.ui.theme.TheFoodBlogTheme
import com.example.thefoodblog.ui.theme.screens.FeedbackScreen
import com.example.thefoodblog.ui.theme.screens.HomeScreen
import com.example.thefoodblog.ui.theme.screens.ProfileScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheFoodBlogTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()


                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            HomeScreen(navController = navController)
                        }
                        composable(Screen.Feedback.route) {
                            FeedbackScreen(navController = navController)
                        }
                        composable(Screen.Profile.route) {
                            ProfileScreen(navController = navController)
                        }
                    }

                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()

    TheFoodBlogTheme {
        MainApp(navController = navController)
    }
}


