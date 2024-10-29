package org.example.myfirstkmp.ui.postscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject
import org.example.myfirstkmp.data.remote.PostRepository

@Inject
class PostViewModel(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _postViewState = MutableStateFlow(PostViewState())
    val postViewState = _postViewState

    fun handleIntent(postIntent: PostIntent) {
        when (postIntent) {
            is PostIntent.LoadPost -> getPost()
        }
    }

    private fun getPost() {
        _postViewState.value = _postViewState.value.copy(isLoading = true)
        viewModelScope.launch {
            try {
                val posts = postRepository.getPosts()
                _postViewState.value = PostViewState(isLoading = false, posts = posts)
            } catch (e: Exception) {
                _postViewState.value = PostViewState(isLoading = false, error = e.message)
            }

        }
    }

}