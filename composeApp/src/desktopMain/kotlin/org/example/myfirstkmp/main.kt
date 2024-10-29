package org.example.myfirstkmp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.myfirstkmp.di.DesktopAppComponent
import org.example.myfirstkmp.di.DesktopScreenComponent
import org.example.myfirstkmp.di.ShareNetworkComponent
import org.example.myfirstkmp.di.ShareScreenComponent
import org.example.myfirstkmp.di.create

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyFirstKMP",
    ) {
        val windowSizeClass = calculateWindowSizeClass()
        val desktopAppComponent = DesktopAppComponent::class.create()
        val networkComponent = ShareNetworkComponent::class.create(desktopAppComponent)
        val desktopScreenComponent =
            DesktopScreenComponent::class.create(networkComponent, windowSizeClass)
        desktopScreenComponent.kmpApp()
    }
}