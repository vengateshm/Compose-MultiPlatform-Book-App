package dev.vengateshm.compose.bookapp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dev.vengateshm.compose.bookapp.di.initKoin
import io.ktor.client.engine.okhttp.OkHttp

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