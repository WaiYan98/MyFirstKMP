package org.example.myfirstkmp.di

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import me.tatarka.inject.annotations.Component

@Component
abstract class AndroidScreenComponent(
    @Component val networkComponent: ShareNetworkComponent,
    private val windowSizeClass: WindowSizeClass
) :
    ShareScreenComponent {

    override fun windowWidthSizeClass(): WindowWidthSizeClass {
        return windowSizeClass.widthSizeClass
    }
}