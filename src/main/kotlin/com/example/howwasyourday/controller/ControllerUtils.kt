package com.example.howwasyourday.controller

import com.example.howwasyourday.entity.User
import com.example.howwasyourday.repository.UserRepository
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Component
import java.security.Principal

@Component
class ControllerUtils(
    val userRepository: UserRepository
) {
    fun getUserFromPrincipal(principal: Principal): User {
        val token = principal as OAuth2AuthenticationToken
        val email = token.principal.attributes["email"] as String
        return userRepository.findByEmail(email) ?: throw ClassNotFoundException()
    }
}

