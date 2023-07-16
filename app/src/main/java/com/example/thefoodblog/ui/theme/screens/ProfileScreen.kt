package com.example.thefoodblog.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.thefoodblog.R
import com.example.thefoodblog.components.BottomNavigationBarComponent

import com.example.thefoodblog.components.TopAppbarComponent

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar
        TopAppbarComponent()

        // Content
        Box(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 6.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Box {
                    // User profile background image
                    Image(
                        painter = painterResource(id = R.drawable.river_gb46c3b0a4_1280),
                        contentDescription = "userProfileBackground",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 90.dp)
                            .align(Alignment.Center)
                            .fillMaxWidth(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "User",
                            modifier = Modifier
                                .size(146.dp)
                        )
                        Text(text = "Hazel Grace", fontSize = 28.sp,
                            fontFamily = FontFamily.Cursive,
                            fontWeight = FontWeight.Bold
                        )

                        Text(text = stringResource(id = R.string.user_bio),
                            fontSize = 15.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }

                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(modifier = Modifier
                    .background(
                        color = colorResource(id = R.color.Gold_sand),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .size(320.dp, 310.dp)

                ) {

                    //INFORMATION
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = stringResource(id = R.string.username))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = stringResource(id = R.string.email))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = stringResource(id = R.string.Contact))
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(text = stringResource(id = R.string.Website))
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(text = "Lets connect!", modifier = Modifier.padding(start = 75.dp))

                        Row(modifier = Modifier.padding(top = 16.dp, start = 50.dp)) {
                            // Instagram Icon
                            Image(
                                painter = painterResource(id = R.drawable.instagram),
                                contentDescription = "Instagram",
                                modifier = Modifier.size(44.dp)
                            )

                            Spacer(modifier = Modifier.width(15.dp))

                            // Twitter Icon
                            Image(
                                painter = painterResource(id = R.drawable.twitter),
                                contentDescription = "Twitter",
                                modifier = Modifier.size(44.dp)
                            )

                            Spacer(modifier = Modifier.width(15.dp))

                            // Linkedin Icon
                            Image(
                                painter = painterResource(id = R.drawable.linkedin),
                                contentDescription = "Twitter",
                                modifier = Modifier.size(44.dp)
                            )
                        }
                    }




                }


            }
        }

        // Bottom Navigation Bar Component
        Box(modifier = Modifier.fillMaxWidth()) {
            BottomNavigationBarComponent(navController = navController)
        }
    }
}


