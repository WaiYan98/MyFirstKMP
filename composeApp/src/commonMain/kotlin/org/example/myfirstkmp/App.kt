package org.example.myfirstkmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.example.myfirstkmp.data.remote.dto.Post
import org.example.myfirstkmp.di.networkComponent

import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    device: Device
) {
    MaterialTheme {
        val postRepository = networkComponent().postRepository

        var postList by remember { mutableStateOf(emptyList<Post>()) }

        LaunchedEffect(key1 = Unit) {
            postList = postRepository.getPosts()
        }

        if (postList.isEmpty()) {
            Text(
                "we are fetching posts...",
                color = Color.Black
            )
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {

            items(postList) {

                Text(
                    text = it.title,
                    fontSize = 24.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                Text(
                    it.body,
                    fontSize = 16.sp
                )
            }
        }
    }
}
