package com.example.howwasyourday.controller

import com.example.howwasyourday.config.auth.dto.SessionUser
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpSession

@Controller
class HtmlController(
    private val httpSession: HttpSession
) {
    @GetMapping("/")
    fun home(model: Model): String {
        model.addAttribute("hi", "hi")
        val user = httpSession.getAttribute("user") as SessionUser?

        if (user != null) {
            model.addAttribute("user", user)
        }

        return "home"
    }
}