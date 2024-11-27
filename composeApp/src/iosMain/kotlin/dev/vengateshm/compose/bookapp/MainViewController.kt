package dev.vengateshm.compose.bookapp

import androidx.compose.ui.window.ComposeUIViewController
import dev.vengateshm.compose.bookapp.di.initKoin
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App(
    /*engine = Darwin.create()*/
) }