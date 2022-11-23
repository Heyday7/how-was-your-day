package com.example.howwasyourday.service

import com.example.howwasyourday.entity.Diary

interface DiaryService {
    fun post(diary: Diary)
    fun getAll(): List<Diary>
    fun get(id: Long): Diary
    fun getByWriterId(userId: Long): List<Diary>
    fun delete(id: Long)
    fun update(id: Long, diary: Diary): Diary
}