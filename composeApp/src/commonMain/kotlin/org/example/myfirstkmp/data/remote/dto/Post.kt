package org.example.myfirstkmp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)