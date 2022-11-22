package com.example.howwasyourday.service

import com.example.howwasyourday.entity.User

interface UserService {
    fun getById(id: Long): User
}