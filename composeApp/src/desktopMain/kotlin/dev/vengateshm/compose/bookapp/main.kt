package dev.vengateshm.compose.bookapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.vengateshm.compose.bookapp.app.App
import dev.vengateshm.compose.bookapp.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookApp",
        ) {
            App(/*engine = remember {
                OkHttp.create()
            }*/)
        }
    }
}