package org.example.myfirstkmp.ui.postscreen

import org.example.myfirstkmp.data.remote.dto.Post

data class PostViewState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String? = null
)