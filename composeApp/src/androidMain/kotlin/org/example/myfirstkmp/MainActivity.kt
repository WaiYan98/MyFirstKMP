package org.example.myfirstkmp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import org.example.myfirstkmp.common.BaseActivity
import org.example.myfirstkmp.di.AndroidScreenComponent
import org.example.myfirstkmp.di.create


class MainActivity : BaseActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            val screenComponent =
                AndroidScreenComponent::class.create(networkComponent, windowSizeClass)
            screenComponent.kmpApp()
        }
    }
}
