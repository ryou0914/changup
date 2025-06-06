package com.uswchangup.backup.gujo_Parkdaejang.config


import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration



@Configuration
class CookieConfig {

    @Bean
    fun cookieSameSiteSupplier(): CookieSameSiteSupplier {
        // SameSite=None으로 설정! Secure도 자동으로 true로 설정됨 (HTTPS 환경에서만 동작)
        // 사실 잘 모르겟음 뭐하는지
        return CookieSameSiteSupplier.ofNone()
    }

}
// 배포할 땐 HTTPS 환경 꼭 맞춰줘야 함.