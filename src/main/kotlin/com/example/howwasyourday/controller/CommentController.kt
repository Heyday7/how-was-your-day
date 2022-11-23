package com.example.howwasyourday.controller

import com.example.howwasyourday.controller.request.RequestCommentDTO
import com.example.howwasyourday.controller.response.ResponseCommentDTO
import com.example.howwasyourday.entity.Comment
import com.example.howwasyourday.service.CommentService
import com.example.howwasyourday.service.DiaryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("/api/comment")
class CommentController(
        val commentService: CommentService,
        val diaryService: DiaryService,
        val controllerUtils: ControllerUtils
) {
    @GetMapping("/{id}")
    fun one(@PathVariable id: Long): ResponseEntity<ResponseCommentDTO> {
        return ResponseEntity
                .ok()
                .body(commentService.get(id).toResponseCommentDTO())
    }

    @PostMapping("")
    fun new(@RequestBody newComment: RequestCommentDTO, principal: Principal): ResponseEntity<Any> {
        val user = controllerUtils.getUserFromPrincipal(principal)
        val diary = diaryService.get(newComment.diaryId)
        val comment = Comment(
                newComment.title,
                newComment.content,
                user,
                diary
        )
        commentService.post(comment)
        return ResponseEntity
                .ok()
                .body(true)
    }

//    @PutMapping("/{id}")
//    fun update(
//            @PathVariable id: Long,
//            @RequestBody updatedComment: CommentDTO,
//            principal: Principal
//    ): ResponseEntity<Comment> {
//        val user = controllerUtils.getUserFromPrincipal(principal)
//        val diary = diaryService.get(updatedComment.diaryId)
//        val comment = Comment(
//                updatedComment.title,
//                updatedComment.content,
//                user,
//                diary,
//                id
//        )
//        return ResponseEntity
//                .ok()
//                .body(commentService.update(comment))
//    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Any> {
        commentService.delete(id)
        return ResponseEntity
                .ok()
                .body(true)
    }
}