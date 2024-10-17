package com.system.students.manager.controller;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.Assignment;
import com.system.students.manager.model.User_Model;
import com.system.students.manager.user_services.User_Service;

@Controller
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class ReactController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private User_Service teacher_impl_service;

    @Autowired
    private Assigment_services assignment_services;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User_Model user) {
        User_Model existingUser = teacher_impl_service.findByUsername(
                user.getUsername());
        if (existingUser == null ||
                !passwordEncoder.matches(
                        user.getPassword(),
                        existingUser.getPassword())) {
            return ResponseEntity.badRequest()
                    .body("Invalid username or password.");
        }
        return ResponseEntity.ok(existingUser);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User_Model user) {
        System.out.println("Register request received: " + user);
        if (teacher_impl_service.findByUsername(user.getUsername()) != null) {
            return ResponseEntity.badRequest()
                    .body("Username is already taken.");
        }
        User_Model registeredUser = teacher_impl_service.save(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String username = authentication.name();
        User_Model profile = teacher_impl_service.findByUsername(username);
        return ResponseEntity.ok(profile);
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllassignments() {
        return assignment_services.getAllAssign();
    }

}
