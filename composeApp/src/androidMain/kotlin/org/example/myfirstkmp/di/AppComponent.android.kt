package org.example.myfirstkmp.di

import io.ktor.client.engine.android.Android

actual fun appComponent(): AppComponent {
    return AppComponent::class.create(Android.create())
}