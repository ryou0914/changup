package com.uswchangup.backup.gujo_Parkdaejang.repository

import com.uswchangup.backup.gujo_Parkdaejang.dto.FormDto
import com.uswchangup.backup.gujo_Parkdaejang.entity.FormEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FormRepository: JpaRepository<FormEntity, Long> {
}