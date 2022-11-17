package com.example.howwasyourday.service

import com.example.howwasyourday.User

interface UserService {
    fun getById(id: Long): User
}