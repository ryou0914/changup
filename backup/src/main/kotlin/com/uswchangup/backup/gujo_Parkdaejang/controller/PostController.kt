package com.uswchangup.backup.gujo_Parkdaejang.controller

import com.uswchangup.backup.gujo_Parkdaejang.dto.PostDto
import com.uswchangup.backup.gujo_Parkdaejang.repository.FormRepository
import com.uswchangup.backup.gujo_Parkdaejang.repository.PostRepository
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.userdetails.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val formRepository: FormRepository
) {

    @GetMapping("/post")
    fun getPosts(): List<PostDto> =
        formRepository.findAll().map {
            PostDto(
                id = it.id ?: 0,
                name = maskName(it.name),
                createdAt = it.createdAt
            )
        }

    fun maskName(name: String?): String {
        if (name.isNullOrBlank()) return "익명"
        return name.mapIndexed { i, c -> if (i == 1) '*' else c }.joinToString("")
    }
}
