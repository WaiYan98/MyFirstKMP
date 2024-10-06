package org.example.myfirstkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.myfirstkmp.di.appComponent

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyFirstKMP",
    ) {
        App(remember { Device() })
    }
}