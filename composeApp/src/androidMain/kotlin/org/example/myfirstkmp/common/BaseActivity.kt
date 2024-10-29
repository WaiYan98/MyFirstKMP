package org.example.myfirstkmp.common

import androidx.activity.ComponentActivity

import org.example.myfirstkmp.di.ShareNetworkComponent
import org.example.myfirstkmp.di.create

open class BaseActivity : ComponentActivity() {

    private val androidAppComponent by lazy {
        (application as MyApplication).androidAppComponent
    }

    protected val networkComponent by lazy {
        ShareNetworkComponent::class.create(androidAppComponent)
    }
}