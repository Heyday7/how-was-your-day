package com.example.howwasyourday.controller

import com.example.howwasyourday.controller.request.RequestActionDTO
import com.example.howwasyourday.controller.request.RequestDiaryDTO
import com.example.howwasyourday.controller.response.ResponseActionDTO
import com.example.howwasyourday.controller.response.ResponseCommentDTO
import com.example.howwasyourday.controller.response.ResponseDiaryDTO
import com.example.howwasyourday.controller.response.ResponseUserDTO
import com.example.howwasyourday.entity.Action
import com.example.howwasyourday.entity.Comment
import com.example.howwasyourday.entity.Diary
import com.example.howwasyourday.entity.User

fun Diary.toResponseDiaryDTO(): ResponseDiaryDTO = ResponseDiaryDTO(
        id ?: 0,
        title,
        body,
        isPrivate,
        writer.toResponseUserDTO(),
        actions.map { it.toResponseActionDTO() },
        comments.map { it.toResponseCommentDTO() }
)

fun Action.toResponseActionDTO(): ResponseActionDTO = ResponseActionDTO(
        id ?: 0,
        type,
        comment
)

fun User.toResponseUserDTO(): ResponseUserDTO = ResponseUserDTO(
        id ?: 0,
        email,
        name,
        picture,
        role,
        createdAt,
        diaries.map { it.id ?: 0 },
        comments.map { it.id ?: 0 }
)

fun Comment.toResponseCommentDTO(): ResponseCommentDTO = ResponseCommentDTO(
        id ?: 0,
        title,
        content,
        diary.id ?: 0,
        user.toResponseUserDTO()
)

fun RequestActionDTO.toAction(): Action = Action(
        type, comment
)

fun RequestDiaryDTO.toDiary(user: User): Diary {
    val diary = Diary(
            title,
            body,
            isPrivate,
            user
    )
    // 아래 작업이 자연스러운지~~ 궁금하다.
    actions.forEach {
        diary.addAction(it.toAction())
    }

    return diary
}
