package com.system.students.manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.model.User_Model;
import com.system.students.manager.user_services.User_Interface;

@Controller
public class Teacher_Controller {

    @Autowired
    private User_Interface teacher_services;

    @GetMapping("/teachers/profile")
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User_Model teacher = teacher_services.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_profile";
    }

    /// teachers profile edit controllers POST & GETMAPPING
    @GetMapping("/teachers/profile/edit")
    public String editProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        // Teacher_model teacher = teacher_repo.findByUsername(username);
        User_Model teacher = teacher_services.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_edit";
    }

    // checked fix duplicate save
    @PostMapping("/teachers/profile/edit")
    public String editTeacherForm(@ModelAttribute("teacher") User_Model teacher_model) {
        // teacher_repo.update_teacher(teacher_model);
        teacher_services.update_teacher(teacher_model);
        return "redirect:/teachers/profile";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    // checked
    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model) {
        model.addAttribute("teacher", new User_Model());
        return "create_teacher_form";
    }

    //////////////////////////////////////////////////////////////////////////////////
    // checked
    @GetMapping("/teachers/edit/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        Optional<User_Model> teacher = teacher_services.get_byId(id);
        model.addAttribute("teacher", teacher);
        // return "teacher_edit";
        return "create_teacher_form";
    }

    /////////////////////////////////////////////////////////////////////////////////////

}
