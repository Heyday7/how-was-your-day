package com.example.howwasyourday.controller.request

data class RequestCommentDTO(
    val title: String,
    val content: String,
    val diaryId: Long
)