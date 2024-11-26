package dev.vengateshm.compose.bookapp

import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController { App(
    engine = Darwin.create()
) }