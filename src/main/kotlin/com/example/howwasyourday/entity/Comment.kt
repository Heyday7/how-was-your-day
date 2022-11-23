package com.example.howwasyourday.entity

import javax.persistence.*

@Entity
class Comment(
        @Column(nullable = false)
        var title: String,
        @Column(nullable = false)
        var content: String,
        user: User,
        diary: Diary
): PrimaryKeyEntity() {
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        var user: User = user
                protected set

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "diary_id", nullable = false)
        var diary: Diary = diary
                protected set
}