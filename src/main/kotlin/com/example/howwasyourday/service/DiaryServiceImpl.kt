package com.example.howwasyourday.service

import com.example.howwasyourday.entity.Diary
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
    override fun getByWriterId(userId: Long): List<Diary> =
        diaryRepository.findByWriterId(userId)

    override fun delete(id: Long) {
        diaryRepository.deleteById(id)
    }

    override fun update(id: Long, modifiedDiary: Diary): Diary {
        val currentDiary = diaryRepository.findByIdOrNull(id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This diary does not exist.")
        if (currentDiary.writer == modifiedDiary.writer) {
            currentDiary.title = modifiedDiary.title
            currentDiary.body = modifiedDiary.body
            currentDiary.isPrivate = modifiedDiary.isPrivate
            currentDiary.clearAction()
            modifiedDiary.actions.forEach { action ->
                currentDiary.addAction(action)
            }
        } else {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "You are not allowed to update this.")
        }

        return diaryRepository.save(currentDiary)
    }
}