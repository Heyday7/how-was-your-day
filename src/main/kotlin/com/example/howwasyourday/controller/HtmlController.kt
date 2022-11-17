package com.example.howwasyourday.controller

import com.example.howwasyourday.config.auth.dto.SessionUser
import com.example.howwasyourday.service.DiaryService
import com.example.howwasyourday.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpSession

@Controller
class HtmlController(
    private val httpSession: HttpSession,
    private val diaryService: DiaryService,
    private val userService: UserService
) {
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("hi", "hi")
        val sessionUser = httpSession.getAttribute("user") as SessionUser?
        if (sessionUser != null) {
            val user = userService.getById(sessionUser.id)
            model.addAttribute("user", user)
        }

        return "home"
    }

    @GetMapping("/diary")
    fun diaryPost(model: Model): String {
        return "diary-post"
    }
}