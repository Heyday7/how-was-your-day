package com.example.howwasyourday.repository

import com.example.howwasyourday.entity.Action
import com.example.howwasyourday.entity.Diary
import org.springframework.data.repository.CrudRepository

interface DiaryRepository: CrudRepository<Diary, Long> {
    fun findByWriterId(id: Long): List<Diary>
}

interface ActionRepository: CrudRepository<Action, Long>