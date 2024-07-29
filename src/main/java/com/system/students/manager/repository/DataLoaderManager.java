package com.system.students.manager.repository;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.system.students.manager.teacher_services.Teacher_impl_service;


@Configuration
public class DataLoaderManager {

    @Bean
    public CommandLineRunner dataLoader(Teacher_impl_service teacher_impl_service) {
        return args -> {
            teacher_impl_service.createUser("admin", "adminpass", Set.of("ADMIN"));
            teacher_impl_service.createUser("lucas", "lucas", Set.of("USER"));
        };
    }
}
