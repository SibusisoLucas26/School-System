package com.system.students.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.Assignment;
import com.system.students.manager.model.User_Model;
import com.system.students.manager.user_services.User_Interface;

@Controller
public class Login_Controller {

    @Autowired
    private User_Interface teacher_services;

    @Autowired
    private Assigment_services assigment_services;

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/login")
    public String loginPage(Model model) {
        // model.addAttribute("teacher", new Teacher_model());
        return "Login-Page";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/admin/dashboard")
    public String AdminDashboard(Model model, Principal principal) {
        return "admin_page";

    }

    // checked for teachers login only
    @GetMapping("/user/dashboard")
    public String Dashboard(Model model, Principal principal) {
        String username = principal.getName();
        User_Model teacher_model = teacher_services.findByUsername(username);
        List<Assignment> assignments = assigment_services.getAllAssign();

        model.addAttribute("teacher", teacher_model);
        model.addAttribute("assignments", assignments);
        return "teacher_dashboard";

    }

    // checked
    @GetMapping("/logout")
    public String logout() {
        // Add code to invalidate session or clear authentication
        return "redirect:/home";
    }

}
