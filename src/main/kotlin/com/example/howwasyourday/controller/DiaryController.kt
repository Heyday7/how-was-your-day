package com.example.howwasyourday.controller

import com.example.howwasyourday.Diary
import com.example.howwasyourday.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DiaryController(
        val diaryService: DiaryService
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
    fun newDiary(@RequestBody newDiary: Diary): ResponseEntity<Any> {
        diaryService.post(newDiary)
        return ResponseEntity
                .ok()
                .body(true)
    }
}