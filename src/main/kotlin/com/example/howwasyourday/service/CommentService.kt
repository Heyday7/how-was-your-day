package com.example.howwasyourday.service

import com.example.howwasyourday.entity.Comment

interface CommentService {
    fun post(comment: Comment)
    fun get(id: Long): Comment
    fun getByDiaryId(diaryId: Long): List<Comment>
    fun getByUserId(userId: Long): List<Comment>
    fun update(comment: Comment): Comment
    fun delete(id: Long)
}