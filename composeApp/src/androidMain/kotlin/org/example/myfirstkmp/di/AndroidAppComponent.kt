package org.example.myfirstkmp.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android
import me.tatarka.inject.annotations.Component

@AppScope
@Component
abstract class AndroidAppComponent : ShareAppComponent {

    override fun engine(): HttpClientEngine {
        return Android.create()
    }
}