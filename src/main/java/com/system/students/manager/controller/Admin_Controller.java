package com.system.students.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Teacher_repo;
import com.system.students.manager.teacher_services.Teacher_services;

import jakarta.validation.Valid;

@Controller
public class Admin_Controller {

    @Autowired
    private Teacher_services teacher_services;

    @Autowired
    private Teacher_repo teacher_repo;

    @GetMapping("/teachers/admin/edit")
    public String editProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher_model teacher = teacher_repo.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_admin_edit";
    }

    @PostMapping("/teachers/admin/edit")
    public String updateProfile(@Valid @ModelAttribute("teacher") Teacher_model teacher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "teacher_profile_edit";
        }
        teacher_services.update_teacher(teacher);
        return "teacher_page_list";
    }

}
