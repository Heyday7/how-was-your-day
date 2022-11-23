package com.example.howwasyourday.entity

import javax.persistence.*

@Entity
class Diary(
    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var body: String = "",

    @Column(nullable = false)
    var isPrivate: Boolean = false,
    writer: User
): PrimaryKeyEntity() {
    @OneToMany(
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    private val _actions: MutableList<Action> = mutableListOf()
    val actions: List<Action> get() = _actions.toList()


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var writer: User = writer
        protected set

    fun addAction(action: Action) {
        _actions.add(action)
    }
    fun removeAction(action: Action) {
        _actions.remove(action)
    }
    fun clearAction() {
        _actions.clear()
    }

    @OneToMany(
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY,
        mappedBy = "diary"
    )
    private val _comments: MutableList<Comment> = mutableListOf()
    val comments: List<Comment> get() = _comments.toList()

    fun addComment(comment: Comment) {
        _comments.add(comment)
    }
    fun removeComment(comment: Comment) {
        _comments.remove(comment)
    }
}


