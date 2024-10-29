package org.example.myfirstkmp.di

import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides
import org.example.myfirstkmp.ui.postscreen.PostViewModel

@Component
actual abstract class ShareViewModelComponent {
    @Provides
    actual fun viewModel(): PostViewModel {
        TODO("Not yet implemented")
    }

}