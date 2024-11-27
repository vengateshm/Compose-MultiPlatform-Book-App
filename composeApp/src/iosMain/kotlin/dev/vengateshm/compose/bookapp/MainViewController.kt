package dev.vengateshm.compose.bookapp

import androidx.compose.ui.window.ComposeUIViewController
import dev.vengateshm.compose.bookapp.app.App
import dev.vengateshm.compose.bookapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App(
    /*engine = Darwin.create()*/
) }