package com.example.thefoodblog

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thefoodblog.components.BottomNavigationBarComponent
import com.example.thefoodblog.components.Screen
import com.example.thefoodblog.ui.theme.screens.FeedbackScreen
import com.example.thefoodblog.ui.theme.screens.HomeScreen
import com.example.thefoodblog.ui.theme.screens.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(navController: NavHostController){

    Scaffold(
        bottomBar = {
            BottomNavigationBarComponent(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
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