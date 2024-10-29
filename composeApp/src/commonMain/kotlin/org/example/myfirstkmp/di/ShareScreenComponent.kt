package org.example.myfirstkmp.di

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import me.tatarka.inject.annotations.Provides
import org.example.myfirstkmp.ui.KmpApp


interface ShareScreenComponent {

    val kmpApp: KmpApp

    @Provides
    fun windowWidthSizeClass(): WindowWidthSizeClass
}