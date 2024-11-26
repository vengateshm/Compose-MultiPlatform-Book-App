package dev.vengateshm.compose.bookapp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.engine.okhttp.OkHttp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BookApp",
    ) {
        App(engine = remember {
            OkHttp.create()
        })
    }
}