package com.furkanekiz.statemanagementcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtherScreen() {
    Surface(color = Color.LightGray) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val myString = remember { mutableStateOf("Android Compose") }

            BasicTextField(myString.value, onValueChange = {
                myString.value = it
                println(myString.value)
            })

            Spacer(modifier = Modifier.padding(7.dp))

            val textString = remember {
                mutableStateOf("Hello")
            }

            Text(
                text = textString.value,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.padding(7.dp))

            Button(onClick = {
                textString.value = "Android"
            }) {
                Text(text = "Test")
                Text(text = "Button")
            }

            Spacer(modifier = Modifier.padding(7.dp))

            Image(
                bitmap = ImageBitmap.imageResource(id = R.drawable.lightsimage),
                contentDescription = "Lights"
            )

            Spacer(modifier = Modifier.padding(7.dp))

            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )

            Spacer(modifier = Modifier.padding(7.dp))

            Image(
                painter = ColorPainter(Color.Black),
                contentDescription = null,
                modifier = Modifier.size(50.dp, 50.dp)
            )
        }
    }

}
