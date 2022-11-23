package com.example.howwasyourday.repository

import com.example.howwasyourday.entity.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository: CrudRepository<Comment, Long> {
    fun findByDiaryId(id: Long): List<Comment>
    fun findByUserId(id: Long): List<Comment>
}