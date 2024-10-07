package org.example.myfirstkmp.common

import android.app.Application
import org.example.myfirstkmp.di.AndroidAppComponent
import org.example.myfirstkmp.di.create

class MyApplication : Application() {

    lateinit var androidAppComponent: AndroidAppComponent

    override fun onCreate() {
        super.onCreate()
        androidAppComponent = AndroidAppComponent::class.create()
    }
}