package com.example.howwasyourday.controller.response

import com.example.howwasyourday.entity.ActionType

data class ResponseActionDTO(
    val id: Long,
    val type: ActionType,
    val comment: String
)