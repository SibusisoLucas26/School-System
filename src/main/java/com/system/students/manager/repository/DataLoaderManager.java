package com.system.students.manager.repository;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.system.students.manager.user_services.User_Service;

@Configuration
public class DataLoaderManager {

    @Bean
    public CommandLineRunner dataLoader(User_Service user_service) {
        return args -> {
            user_service.createUser("admin", "admin", "admin", "admin",
                    "adminpass", Set.of("ADMIN"));
            user_service.createUser("sibusiso", "lucas", "mbanjwa",
                    "lucas", "lucas", Set.of("USER"));
        };
    }
}
