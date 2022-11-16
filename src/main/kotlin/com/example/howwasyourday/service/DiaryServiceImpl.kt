package com.example.howwasyourday.service

import com.example.howwasyourday.Diary
import com.example.howwasyourday.repository.DiaryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class DiaryServiceImpl(
        val diaryRepository: DiaryRepository
): DiaryService {
    override fun get(id: Long): Diary =
        diaryRepository.findByIdOrNull(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "This diary does not exist")

    override fun getAll(): List<Diary> =
        diaryRepository.findAll().toList()

    override fun post(diary: Diary) {
        diaryRepository.save(diary)
    }

    override fun getByUserId(userId: Long): List<Diary> =
        diaryRepository.findByUserId(userId)
}