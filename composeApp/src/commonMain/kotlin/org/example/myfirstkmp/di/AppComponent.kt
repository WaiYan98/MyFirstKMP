package org.example.myfirstkmp.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides


@AppScope
@Component
abstract class AppComponent(private val engine: HttpClientEngine) {

    @Provides
    fun engine(): HttpClientEngine = engine

    @AppScope
    @Provides
    fun client(engine: HttpClientEngine): HttpClient = HttpClient(engine) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
    }
}

expect fun appComponent(): AppComponent

