package com.example.howwasyourday

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Diary(
    @OneToMany(cascade = [CascadeType.PERSIST])
    val actions: List<Action> = emptyList(),
    val body: String = "",
) {
    @Id @GeneratedValue
    val id: Long = 0
}

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
