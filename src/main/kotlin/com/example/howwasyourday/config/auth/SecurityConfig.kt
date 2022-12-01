package com.example.howwasyourday.config.auth

import com.example.howwasyourday.entity.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

//@EnableWebSecurity
//class SecurityConfig(
//    @Autowired private val customOAuth2UserService: CustomOAuth2UserService
//): WebSecurityConfigurerAdapter() {
//    override fun configure(http: HttpSecurity?) {
//        if (http == null) throw Exception()
//
//        http
//            .csrf().disable()
//            .headers().frameOptions().disable()
//            .and()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/api/**").hasRole(Role.USER.name)
//                .anyRequest().authenticated()
//            .and()
//                .logout().logoutSuccessUrl("/")
//            .and()
//                .oauth2Login()
//                .userInfoEndpoint()
//                .userService(customOAuth2UserService)
//    }
//}

@EnableWebSecurity
class SecurityConfig(
    @Autowired private val customOAuth2UserService: CustomOAuth2UserService
) {
    @Bean
    fun filterChain(http: HttpSecurity?): SecurityFilterChain {
        if (http == null) throw Exception()

        return http
            .csrf().disable()
            .headers().frameOptions().disable()
            .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/**").hasRole(Role.USER.name)
                .anyRequest().authenticated()
            .and()
                .logout()
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
            .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
            .and()
            .defaultSuccessUrl("/")
            .and()
            .build()
    }
}