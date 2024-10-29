package org.example.myfirstkmp.data.remote

import org.example.myfirstkmp.data.remote.dto.Post

class FakeRepository : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return emptyList()
    }
}