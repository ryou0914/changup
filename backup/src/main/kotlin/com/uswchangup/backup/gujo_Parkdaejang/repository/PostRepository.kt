package com.uswchangup.backup.gujo_Parkdaejang.repository

import com.uswchangup.backup.gujo_Parkdaejang.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<PostEntity, Long>
