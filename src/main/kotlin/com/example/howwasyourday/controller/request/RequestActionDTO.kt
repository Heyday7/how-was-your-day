package com.example.howwasyourday.controller.request

import com.example.howwasyourday.entity.ActionType

data class RequestActionDTO(
    val type: ActionType = ActionType.Any,
    val comment: String
)