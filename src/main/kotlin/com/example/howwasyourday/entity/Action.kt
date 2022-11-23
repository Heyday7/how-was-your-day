package com.example.howwasyourday.entity

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "action")
class Action(
    @Column(nullable = false)
    var type: ActionType = ActionType.Any,

    @Column(nullable = false)
    var comment: String,
): PrimaryKeyEntity() {
    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
}

enum class ActionType {
    Work, Study, Exercise, Hobby, Any
}