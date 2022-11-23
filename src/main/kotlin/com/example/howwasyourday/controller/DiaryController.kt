package com.example.howwasyourday.controller

import com.example.howwasyourday.controller.request.RequestDiaryDTO
import com.example.howwasyourday.controller.response.ResponseDiaryDTO
import com.example.howwasyourday.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api")
class DiaryController(
        val diaryService: DiaryService,
        val controllerUtils: ControllerUtils
) {
    @GetMapping("/diaries")
    fun all(): ResponseEntity<List<ResponseDiaryDTO>> {
        return ResponseEntity
                .ok()
                .body(diaryService.getAll().map { it.toResponseDiaryDTO() })
    }

    @GetMapping("/diaries/{id}")
    fun one(@PathVariable id: Long): ResponseEntity<ResponseDiaryDTO> {
        return ResponseEntity
                .ok()
                .body(diaryService.get(id).toResponseDiaryDTO())
    }

    @PostMapping("/diaries")
    fun newDiary(@RequestBody newDiary: RequestDiaryDTO, principal: Principal): ResponseEntity<Any> {
        val user = controllerUtils.getUserFromPrincipal(principal)
        val diary = newDiary.toDiary(user)
        diaryService.post(diary)
        return ResponseEntity
                .ok()
                .body(true)
    }

    @DeleteMapping("/diaries/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        diaryService.delete(id)
        return ResponseEntity
                .ok()
                .body(true)
    }

    @PutMapping("/diaries/{id}")
    fun update(
            @PathVariable id: Long,
            @RequestBody modifiedDiary: RequestDiaryDTO,
            principal: Principal
    ): ResponseEntity<ResponseDiaryDTO> {
        val user = controllerUtils.getUserFromPrincipal(principal)
        val diary = modifiedDiary.toDiary(user)
        val savedDiary = diaryService.update(id, diary)

        return ResponseEntity
                .ok()
                .body(savedDiary.toResponseDiaryDTO())
    }
}