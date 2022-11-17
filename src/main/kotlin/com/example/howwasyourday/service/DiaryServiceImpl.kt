package com.example.howwasyourday.service

import com.example.howwasyourday.Diary
import com.example.howwasyourday.config.auth.dto.SessionUser
import com.example.howwasyourday.controller.DiaryDTO
import com.example.howwasyourday.repository.DiaryRepository
import com.example.howwasyourday.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.springframework.web.server.ResponseStatusException

@Service
class DiaryServiceImpl(
        val diaryRepository: DiaryRepository,
        val userRepository: UserRepository
): DiaryService {
    override fun get(id: Long): Diary =
        diaryRepository.findByIdOrNull(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "This diary does not exist")

    override fun getAll(): List<Diary> =
        diaryRepository.findAll().toList()

    override fun post(diaryDTO: DiaryDTO) {
        val a = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
        val sessionUserId = (a.request.session.getAttribute("user") as SessionUser?)?.id ?: throw Exception()
        val user = userRepository.findByIdOrNull(sessionUserId) ?: throw Exception()
        val diary = Diary(
            diaryDTO.actions,
            diaryDTO.title,
            diaryDTO.body,
            diaryDTO.isPrivate,
            user
        )
        diaryRepository.save(diary)
    }

    override fun getByUserId(userId: Long): List<Diary> =
        diaryRepository.findByUserId(userId)
}