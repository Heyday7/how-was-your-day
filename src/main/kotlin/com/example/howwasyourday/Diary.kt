package com.example.howwasyourday

import javax.persistence.*

@Entity
data class Diary(
    @OneToMany(cascade = [CascadeType.PERSIST])
    val actions: List<Action> = emptyList(),
    val title: String = "",
    val body: String = "",
    @ManyToOne(fetch = FetchType.LAZY)
    val user: User
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
