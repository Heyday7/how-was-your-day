package com.example.howwasyourday.config.auth

import com.example.howwasyourday.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig(
    @Autowired private val customOAuth2UserService: CustomOAuth2UserService
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        if (http == null) throw Exception()

        http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").hasRole(Role.USER.name)
                .anyRequest().authenticated()
            .and()
                .logout().logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
    }
}