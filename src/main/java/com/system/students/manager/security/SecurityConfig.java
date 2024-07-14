package com.system.students.manager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/h2-console/**","/home","/teachers/reg","/teachers/page","/teachers/new","/teachers/page","/teachers/admin/edit","/teachers/edit/{id}" ,"/stylesheet/**", "/list.css", "/index.css/**", "/dash.css/**", "/form.css/**")
                .permitAll()
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
            // default post mapping
                .loginPage("/teachers/login")
                .defaultSuccessUrl("/teachers/dashboard", true)
                .permitAll()
            )

          //  .formLogin((form) -> form
            // default post mapping
          //      .loginPage("/admin/login")
         //       .defaultSuccessUrl("/admin/dashboard", true)
         //       .permitAll()
         //   )
            
            .logout(LogoutConfigurer::permitAll)
            .csrf((csrf) -> csrf.ignoringRequestMatchers("/js/**", "/images/**", "/h2-console/**"));

        return http.build();
    }
}
