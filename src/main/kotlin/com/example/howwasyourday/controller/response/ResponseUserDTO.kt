package com.example.howwasyourday.controller.response

import com.example.howwasyourday.entity.Role
import java.time.LocalDateTime

data class ResponseUserDTO(
        val email: String,
        val name: String,
        val picture: String,
        val role: Role,
        val createdAt: LocalDateTime,
        val diaries: List<ResponseDiaryDTO>
)
