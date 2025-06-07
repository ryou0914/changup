package com.uswchangup.backup.gujo_Parkdaejang.dto

import java.time.LocalDateTime

data class PostDto(
    val id: Long,
    val name: String, // 마스킹 처리된 이름
    val content: String = "비밀 글입니다.",
    val createdAt: LocalDateTime?
)
