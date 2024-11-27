package dev.vengateshm.compose.bookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.vengateshm.compose.bookapp.app.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(/*engine = remember {
                OkHttp.create()
            }*/)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(/*engine = remember {
        OkHttp.create()
    }*/)
}