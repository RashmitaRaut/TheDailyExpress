package com.example.thefoodblog.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.thefoodblog.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbarComponent() {                                      //TOP APP BAR
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontFamily = FontFamily.Cursive,
                fontSize = 28.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu"
                )
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Rounded.Favorite,
                    contentDescription = "Favorite"
                )
            }
        }
    )
}

@Composable
fun BottomNavigationBarComponent(navController: NavController) {            // BOTTOM NAVIGATION BAR
    var selectedItem by remember {
        mutableStateOf(0)
    }
    val items = listOf(
        Screen.Home,
        Screen.Profile,
        Screen.Feedback
    )
    val icons = listOf(Icons.Filled.Home, Icons.Filled.Person, Icons.Filled.Email)

    Box(Modifier.background(color = colorResource(id = R.color.Millbrook))) {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    icon = { Icon(icons[index], contentDescription = item.route) },
                    label = { Text(item.route) },
                    selected = selectedItem == index,
                    onClick = {
                        try {
                            navController.navigate(item.route)
                            selectedItem = index
                        } catch (e: Exception) {

                        }
                    }
                )
            }
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val currentIndex = items.indexOfFirst { it.route == currentRoute }
        if (currentIndex != selectedItem) {
            selectedItem = currentIndex
        }
    }
}


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Feedback : Screen("feedback")
    object Profile : Screen("profile")
}










