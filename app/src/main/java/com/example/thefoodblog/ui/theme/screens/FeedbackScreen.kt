package com.example.thefoodblog.ui.theme.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.thefoodblog.R
import com.example.thefoodblog.components.BottomNavigationBarComponent

import com.example.thefoodblog.components.TopAppbarComponent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun FeedbackScreen(navController: NavHostController) {
    val softwareKeyboardController = LocalSoftwareKeyboardController.current
    val buttonVisible = remember { mutableStateOf(true) }
    val imageVisible = remember { mutableStateOf(false) }

    TopAppbarComponent()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(30.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(id = R.drawable.feedback_bcgover),
                contentDescription = "feedback cover",
                modifier = Modifier.shadow(30.dp)
            )
            
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Feedback form",
                fontFamily = FontFamily.SansSerif,
                fontSize = 20.sp,
                
            )

            Text(
                text = "Help us get better",
                fontFamily = FontFamily.SansSerif,
                fontSize = 12.sp,

            )

            Spacer(modifier = Modifier.height(20.dp))

            Box() {

            }
            var subject by remember { mutableStateOf("") }
            val focusRequesterForBody = remember { FocusRequester() }
            TextField(

                value = subject,
                onValueChange = { subject = it },
                label = { Text("Subject") },
                modifier = Modifier.fillMaxWidth().background(Color.Black),
                textStyle = LocalTextStyle.current.copy(color = Color.Black),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { focusRequesterForBody.requestFocus() }
                ),
            )

            Spacer(modifier = Modifier.height(20.dp))

            var body by remember { mutableStateOf("") }
            val focusRequesterForEmail = remember { FocusRequester() }
            TextField(

                value = body,
                onValueChange = { body = it },
                label = { Text("Body") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { focusRequesterForEmail.requestFocus() }
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterForBody)
                    .padding(bottom = 16.dp)
                )

            Spacer(modifier = Modifier.height(20.dp))

            var email by remember { mutableStateOf("") }
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {

                        softwareKeyboardController?.hideSoftwareKeyboard();
                        // Form submission
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequesterForEmail)
            )
            
            Spacer(modifier = Modifier.height(30.dp))


            Column {
                if (buttonVisible.value) {
                    Button(
                        onClick = {
                            buttonVisible.value = false
                            imageVisible.value = true
                        },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.Gold_sand))
                    ) {
                        Text(
                            text = "Submit",
                            Modifier.padding(10.dp),
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                if (imageVisible.value) {
                    Image(
                        painter = painterResource(R.drawable.check),
                        contentDescription = "Your Image",
                        modifier = Modifier.size(72.dp)
                    )
                }
            }


        }

        // Bottom Navigation Bar Component
        BottomNavigationBarComponent(navController = navController)
    }
}
