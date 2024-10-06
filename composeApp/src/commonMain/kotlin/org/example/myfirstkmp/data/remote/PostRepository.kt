package org.example.myfirstkmp.data.remote

import org.example.myfirstkmp.data.remote.dto.Post

interface PostRepository {

    suspend fun getPosts() : List<Post>
}