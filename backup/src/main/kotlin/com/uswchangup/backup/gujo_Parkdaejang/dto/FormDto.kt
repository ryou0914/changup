package com.uswchangup.backup.gujo_Parkdaejang.dto


import com.uswchangup.backup.gujo_Parkdaejang.entity.FormEntity
import java.time.LocalDateTime

data class  FormDto (
    val id: Long?,
    val name: String,
    val number: String,
    val content: String,
    val createdAt: LocalDateTime? = null
) {
    fun toEntity(): FormEntity {
        return FormEntity(
            name = this.name,
            number = this.number,
            content = this.content,
            createdAt = this.createdAt
        )
    }
    companion object {
        fun fromEntity(entity: FormEntity): FormDto {
            return FormDto(
                id = entity.id,
                name = entity.name ?: "",
                number = entity.number ?: "",
                content = entity.content ?: "",
                createdAt = entity.createdAt
            )
        }
    }

}