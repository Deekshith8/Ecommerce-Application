package com.ecommerceproject.ecommercespringBoot.config;


import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        //protect endpoint /api/orders
        http.authorizeRequests(configurer ->
                                  configurer
                                          .requestMatchers("/api/orders/**")
                                          .authenticated())
                .oauth2ResourceServer()
                .jwt();


        //add cors filters
        http.cors();

        //force a non empty response body for 401s to make the response more friendly
        Okta.configureResourceServer401ResponseBody(http);

        return http.build();
    }
}
