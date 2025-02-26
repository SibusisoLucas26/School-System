package com.system.students.manager.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.system.students.manager.repository.User_repo;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Bean
        public SecurityFilterChain curityFilterChain(HttpSecurity http) throws Exception {
                http          .cors(Customizer.withDefaults())
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/auth/login","/home")
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin((form) -> form
                                                // default post mapping
                                                .loginPage("/login")
                                                .successHandler(new Custom_SucessfullURL())
                                                // .defaultSuccessUrl("/login/dashboard", true)
                                                .permitAll())
                                .logout((logout) -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .invalidateHttpSession(true)
                                                .deleteCookies("JSESSIONID")
                                                .permitAll())
                                .sessionManagement((session) -> session
                                                .maximumSessions(1)
                                                .expiredUrl("/login?expired"));

                return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Autowired
        private User_repo teacher_repo;

        @Bean
        public UserDetailsService userDetailsService() {
                return username -> teacher_repo.findByUsername(username);
        }

}
