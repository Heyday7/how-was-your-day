package com.example.howwasyourday.service

import com.example.howwasyourday.entity.User
import com.example.howwasyourday.repository.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
): UserService {
    override fun getById(id: Long): User =
        userRepository.findByIdOrNull(id) ?: throw NotFoundException()
}