package com.example.howwasyourday.controller

import com.example.howwasyourday.Diary
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
    fun all(): ResponseEntity<List<Diary>> {
        return ResponseEntity
                .ok()
                .body(diaryService.getAll())
    }

    @GetMapping("/diaries/{id}")
    fun one(@PathVariable id: Long): ResponseEntity<Diary> {
        return ResponseEntity
                .ok()
                .body(diaryService.get(id))
    }

    @PostMapping("/diaries")
    fun newDiary(@RequestBody newDiary: DiaryDTO, principal: Principal): ResponseEntity<Any> {
        val user = controllerUtils.getUserFromPrincipal(principal)
        val diary = Diary(
                newDiary.actions,
                newDiary.title,
                newDiary.body,
                newDiary.isPrivate,
                user
        )
        diaryService.post(diary)
        return ResponseEntity
                .ok()
                .body(true)
    }
}