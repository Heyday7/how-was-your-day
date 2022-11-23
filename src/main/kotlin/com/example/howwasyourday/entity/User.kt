package com.example.howwasyourday.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class User(
    email: String,
    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var picture: String,

    @Enumerated(EnumType.STRING)
    var role: Role,
): PrimaryKeyEntity() {
    @Column(unique = true, nullable = false)
    var email = email
        protected set

    @Column(nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @OneToMany(
        cascade = [CascadeType.PERSIST, CascadeType.REMOVE],
        fetch = FetchType.LAZY,
        mappedBy = "writer"
    )
    private val _diaries: MutableList<Diary> = mutableListOf()
    val diaries: List<Diary> get() = _diaries.toList()

    fun addDiary(diary: Diary) {
        _diaries.add(diary)
    }

    fun removeDiary(diary: Diary) {
        _diaries.remove(diary)
    }

    @OneToMany(
            cascade = [CascadeType.ALL],
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    private val _comments: MutableList<Comment> = mutableListOf()
    val comments: List<Comment> get() =  _comments.toList()

    fun addComment(comment: Comment) {
        _comments.add(comment)
    }
    fun removeComment(comment: Comment) {
        _comments.remove(comment)
    }
}

enum class Role(
    val key: String,
    val title: String
) {
    ADMIN("ROLE_ADMIN", "관리자"),
    USER("ROLE_USER", "사용자")
}