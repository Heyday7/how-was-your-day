package com.example.howwasyourday.config.auth.dto

import com.example.howwasyourday.User
import java.io.Serializable

data class SessionUser(
    private val user: User
): Serializable {
    val name = user.name
    val email = user.email
    val picture = user.picture
}