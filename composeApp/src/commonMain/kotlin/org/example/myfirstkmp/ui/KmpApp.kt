package org.example.myfirstkmp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.tatarka.inject.annotations.Inject
import org.example.myfirstkmp.data.remote.dto.Post
import org.example.myfirstkmp.ui.postscreen.PostIntent
import org.example.myfirstkmp.ui.postscreen.PostViewModel

typealias KmpApp = @Composable () -> Unit

@Inject
@Composable
fun KmpApp(
    postViewModel: () -> PostViewModel,
    windowWidthSizeClass: WindowWidthSizeClass
) {

    val viewModel = viewModel { postViewModel() }
    val postViewState by viewModel.postViewState.collectAsState()

    MaterialTheme {

        LaunchedEffect(Unit) {
            viewModel.handleIntent(PostIntent.LoadPost)
        }

        Loading(postViewState.isLoading)

        postViewState.error?.let {
            ErrorBox(it)
        }

        if (windowWidthSizeClass == WindowWidthSizeClass.Expanded
        ) {
            PostListTwoColumn(postViewState.posts)
        } else {
            PostListOneColumn(postViewState.posts)
        }
    }

}

@Composable
fun Loading(isLoading: Boolean) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun ErrorBox(error: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            error,
            color = Color.Red,
            style = TextStyle(fontWeight = FontWeight.Bold),
            fontSize = 24.sp
        )
    }
}

@Composable
fun PostListOneColumn(
    posts: List<Post>
) {
    LazyColumn {
        items(posts) {
            Post(it)
        }
    }
}

@Composable
fun PostListTwoColumn(
    posts: List<Post>
) {
    LazyVerticalGrid(GridCells.Fixed(2)) {
        items(posts) {
            Post(it)
        }
    }
}

@Composable
fun Post(
    post: Post
) {

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 8.dp)
    ) {
        Text(
            text = post.title,
            fontSize = 24.sp,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        Text(
            text = post.body,
            fontSize = 16.sp
        )
    }
}