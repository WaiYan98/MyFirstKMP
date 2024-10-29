package org.example.myfirstkmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import me.tatarka.inject.annotations.Inject
import org.example.myfirstkmp.data.remote.dto.Post

@Inject
class PostRepositoryImpl(private val client: HttpClient) : PostRepository {

    override suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO) {
        try {
            val httpResponse = client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = HttpRoutes.BASE_URL
                    path(HttpRoutes.POST)
                }
            }
            return@withContext httpResponse.body()

        } catch (e: Exception) {
            throw e
        }
    }
}