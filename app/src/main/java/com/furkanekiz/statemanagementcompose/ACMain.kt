package com.furkanekiz.statemanagementcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanekiz.statemanagementcompose.ui.theme.StateManagementComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    //State Hoisting
    val myString = remember {
        mutableStateOf("")
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpecialText(string = "Test")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialText(string = "Android")
            Spacer(modifier = Modifier.padding(5.dp))
            SpecialTextField(myString.value){
                myString.value = it
            }

        }
    }

}

@Composable
fun SpecialText(string: String) {
    Text(
        text = string,
        fontSize = 26.sp,
        fontStyle = FontStyle.Italic,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun SpecialTextField(string: String, function: (String) -> Unit) {
    BasicTextField(
        modifier = Modifier.background(Color.LightGray),
        value = string,
        onValueChange = function)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateManagementComposeTheme {
        MainScreen()
    }
}