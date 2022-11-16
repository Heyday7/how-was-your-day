package com.example.howwasyourday.controller

import com.example.howwasyourday.User
import com.example.howwasyourday.config.auth.dto.SessionUser
import com.example.howwasyourday.repository.DiaryRepository
import com.example.howwasyourday.service.DiaryService
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal
import javax.servlet.http.HttpSession

@Controller
class HtmlController(
    private val httpSession: HttpSession,
    private val diaryService: DiaryService
) {
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("hi", "hi")
        val user = httpSession.getAttribute("user") as SessionUser?

        if (user != null) {
            val diaries = diaryService.getByUserId(user.id)
            model.addAttribute("user", user)
            model.addAttribute("diaries", diaries)
        }

        return "home"
    }

//    @GetMapping("/list")
//    fun list(model: Model): String {
//        val user = SecurityContextHolder.getContext().authentication.principal as User?
//
//        if (user != null) {
//            model.addAttribute()
//        }
//    }
}