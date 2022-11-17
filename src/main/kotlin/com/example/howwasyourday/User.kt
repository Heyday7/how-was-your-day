package com.example.howwasyourday

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
    @Column (unique = true)
    val email: String,
    val name: String,
    val picture: String,

    @OneToMany(
        cascade = [CascadeType.PERSIST],
        fetch = FetchType.LAZY,
        mappedBy = "user"
    )
    val diaries: List<Diary> = emptyList(),

    @Enumerated(EnumType.STRING)
    val role: Role,

    @CreationTimestamp
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Id @GeneratedValue
    val id: Long = 0
)

enum class Role(
    val key: String,
    val title: String
) {
    ADMIN("ROLE_ADMIN", "관리자"), USER("ROLE_USER", "사용자")
}