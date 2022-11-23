package com.example.howwasyourday.controller.response

data class ResponseCommentDTO(
        val id: Long,
        val title: String,
        val content: String,
        val diaryId: Long,
        val user: ResponseUserDTO
)