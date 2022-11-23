package com.example.howwasyourday.controller.response

data class ResponseDiaryDTO(
    val id: Long,
    val title: String,
    val body: String,
    val isPrivate: Boolean,
    val writer: ResponseUserDTO,
    val actions: List<ResponseActionDTO>
)