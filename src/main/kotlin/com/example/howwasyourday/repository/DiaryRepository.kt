package com.example.howwasyourday.repository

import com.example.howwasyourday.Action
import com.example.howwasyourday.Diary
import org.springframework.data.repository.CrudRepository

interface DiaryRepository: CrudRepository<Diary, Long> {
    fun findByUserId(id: Long): List<Diary>
}

interface ActionRepository: CrudRepository<Action, Long>