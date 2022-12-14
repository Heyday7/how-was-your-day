package com.example.howwasyourday.controller

import com.example.howwasyourday.config.auth.dto.SessionUser
import com.example.howwasyourday.service.DiaryService
import com.example.howwasyourday.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpSession

@Controller
class HtmlController(
    private val httpSession: HttpSession,
    private val diaryService: DiaryService,
    private val userService: UserService
) {
    @GetMapping("/")
    fun home(model: Model): String {
        val sessionUser = httpSession.getAttribute("user") as SessionUser?
        if (sessionUser?.id != null) {
            val user = userService.getById(sessionUser.id)
            model.addAttribute("user", user)
        }

        return "home"
    }

    @GetMapping("/diary-post")
    fun diaryPost(model: Model): String {
        return "diary-post"
    }

    @GetMapping("/diary/{id}")
    fun diaryDetail(@PathVariable id: Long, model: Model): String {
        val diary = diaryService.get(id)
        val sessionUser = httpSession.getAttribute("user") as SessionUser?
        if (sessionUser?.id != null) {
            model.addAttribute("userId", sessionUser.id)
        }
        model.addAttribute("diary", diary)

        return "diary-detail"
    }

    @GetMapping("/list")
    fun diaryList(model: Model): String {
        val diaries = diaryService.getAll()
        model.addAttribute("diaries", diaries)

        return "diary-list"
    }

    @GetMapping("/diary/{id}/update")
    fun diaryUpdate(@PathVariable id: Long, model: Model): String{
        val diary = diaryService.get(id)
        model.addAttribute("diary", diary)

        return "diary-update"
    }
}