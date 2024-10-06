package org.example.myfirstkmp.di

import io.ktor.client.engine.HttpClientEngine


actual fun appComponent(): AppComponent {
    return AppComponent::class.create()
}
