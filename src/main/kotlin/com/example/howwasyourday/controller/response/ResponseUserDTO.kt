package com.example.howwasyourday.controller.response

import com.example.howwasyourday.entity.Role
import java.time.LocalDateTime

data class ResponseUserDTO(
        val id: Long,
        val email: String,
        val name: String,
        val picture: String,
        val role: Role,
        val createdAt: LocalDateTime,
        val diaries: List<Long>, // 순환참조를 막기 위해서... 이게 올바른 방법인건가?
        val comments: List<Long>
)
