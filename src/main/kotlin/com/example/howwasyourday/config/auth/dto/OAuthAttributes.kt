package com.example.howwasyourday.config.auth.dto

import com.example.howwasyourday.Role
import com.example.howwasyourday.User

data class OAuthAttributes(
    val attributes: Map<String, Any>,
    val nameAttributeKey: String,
    val name: String,
    val email: String,
    val picture: String,
) {
    companion object {
        fun of(
            registrationId: String,
            userNameAttributeName: String,
            attributes: Map<String, Any>
        ): OAuthAttributes {
            return OAuthAttributes(
                name = attributes["name"] as String,
                email = attributes["email"] as String,
                picture = attributes["picture"] as String,
                attributes = attributes,
                nameAttributeKey = userNameAttributeName
            )
        }
    }
}


fun OAuthAttributes.toEntity(): User {
    return User(
        name = name,
        email = email,
        picture = picture,
        role = Role.USER
    )
}