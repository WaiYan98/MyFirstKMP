package org.example.myfirstkmp.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.apache5.Apache5
import me.tatarka.inject.annotations.Component

@Component
abstract class DesktopAppComponent : ShareAppComponent {

    override fun engine(): HttpClientEngine {
        return Apache5.create()
    }
}