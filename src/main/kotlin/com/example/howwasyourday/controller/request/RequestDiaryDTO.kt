package com.example.howwasyourday.controller.request

data class RequestDiaryDTO(
    val title: String,
    val body: String,
    val isPrivate: Boolean,
    val actions: List<RequestActionDTO> = emptyList()
)