package org.example.myfirstkmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.myfirstkmp.di.DesktopAppComponent
import org.example.myfirstkmp.di.ShareNetworkComponent
import org.example.myfirstkmp.di.create

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyFirstKMP",
    ) {
        val desktopAppComponent = DesktopAppComponent::class.create()
        val networkComponent = ShareNetworkComponent::class.create(desktopAppComponent)
        App(remember { Device() }, networkComponent)
    }
}