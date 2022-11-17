package com.example.howwasyourday.service

import com.example.howwasyourday.Diary
import com.example.howwasyourday.controller.DiaryDTO

interface DiaryService {
    fun post(diaryDTO: DiaryDTO)
    fun getAll(): List<Diary>
    fun get(id: Long): Diary
    fun getByUserId(userId: Long): List<Diary>
}