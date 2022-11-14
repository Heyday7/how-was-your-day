package com.example.howwasyourday

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Action(
    val type: ActionType = ActionType.Any,
    val comment: String,
) {
    @Id @GeneratedValue
    val id: Long = 0
}

enum class ActionType {
    Work, Study, Exercise, Hobby, Any
}