package com.example.howwasyourday.service

import com.example.howwasyourday.entity.Comment
import com.example.howwasyourday.repository.CommentRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CommentServiceImpl (
        val commentRepository: CommentRepository
): CommentService {
    override fun get(id: Long): Comment =
        commentRepository.findByIdOrNull(id) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "This Comment does not exist")

    override fun getByDiaryId(diaryId: Long): List<Comment> =
        commentRepository.findByDiaryId(diaryId)

    override fun getByUserId(userId: Long): List<Comment> =
        commentRepository.findByUserId(userId)

    override fun post(comment: Comment) {
        commentRepository.save(comment)
    }

    override fun update(comment: Comment): Comment =
        commentRepository.save(comment)

    override fun delete(id: Long) {
        commentRepository.deleteById(id)
    }
}
