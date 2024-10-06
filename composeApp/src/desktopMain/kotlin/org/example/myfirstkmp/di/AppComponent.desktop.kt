package org.example.myfirstkmp.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.apache5.Apache5

actual fun appComponent(): AppComponent {
    return AppComponent::class.create(Apache5.create())
}
