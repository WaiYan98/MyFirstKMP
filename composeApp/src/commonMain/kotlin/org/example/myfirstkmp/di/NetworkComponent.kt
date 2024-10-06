package org.example.myfirstkmp.di

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.example.myfirstkmp.data.remote.PostRepository
import org.example.myfirstkmp.data.remote.PostRepositoryImpl

@Component
abstract class NetworkComponent(@Component val appComponent: AppComponent) {

    abstract val postRepository: PostRepository

    @Provides
    fun PostRepositoryImpl.bind(): PostRepository = this
}

expect fun networkComponent(): NetworkComponent
