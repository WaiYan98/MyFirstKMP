package org.example.myfirstkmp.di

actual fun networkComponent(): NetworkComponent {
    return NetworkComponent::class.create(appComponent())
}