package com.example.howwasyourday.controller

import com.example.howwasyourday.Action

data class DiaryDTO(
    val title: String,
    val body: String,
    val actions: List<Action> = emptyList()
)