package com.uswchangup.backup.gujo_Parkdaejang.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "post")
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val number: String,
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),

    val secret: Boolean = true // 기본 비공개
)
