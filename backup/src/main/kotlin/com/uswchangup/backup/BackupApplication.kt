package com.uswchangup.backup


import jakarta.persistence.EntityListeners
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@SpringBootApplication
class BackupApplication

fun main(args: Array<String>) {
    runApplication<BackupApplication>(*args)
}