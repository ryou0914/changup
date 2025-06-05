package com.uswchangup.backup.gujo_Parkdaejang.config


import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration



@Configuration
class CookieConfig {

    @Bean
    fun cookieSameSiteSupplier(): CookieSameSiteSupplier {
        // SameSite=None 으로 설정 (HTTPS 환경 필요!)
        return CookieSameSiteSupplier.ofNone()
    }

}
// 배포할 땐 HTTPS 환경 꼭 맞춰줘야 함.