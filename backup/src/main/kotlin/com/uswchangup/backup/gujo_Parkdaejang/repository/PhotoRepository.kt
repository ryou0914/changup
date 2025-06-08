package com.uswchangup.backup.gujo_Parkdaejang.repository

import com.uswchangup.backup.gujo_Parkdaejang.entity.PhotoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PhotoRepository : JpaRepository<PhotoEntity, Long>