package com.example.howwasyourday.controller.response

import com.example.howwasyourday.controller.request.RequestActionDTO
import com.example.howwasyourday.controller.request.RequestDiaryDTO
import com.example.howwasyourday.entity.Action
import com.example.howwasyourday.entity.Diary
import com.example.howwasyourday.entity.User

fun Diary.toResponseDiaryDTO(): ResponseDiaryDTO = ResponseDiaryDTO(
        title,
        body,
        isPrivate,
        writer.toResponseUserDTO(),
        actions.map { it.toResponseActionDTO() }
)

fun Action.toResponseActionDTO(): ResponseActionDTO = ResponseActionDTO(
        type,
        comment
)

fun User.toResponseUserDTO(): ResponseUserDTO = ResponseUserDTO(
        email,
        name,
        picture,
        role,
        createdAt,
        diaries.map { it.toResponseDiaryDTO() }
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