package com.system.students.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.Admin_model;
import com.system.students.manager.model.StudentAssignment;
import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.student_services.Student_service;
import com.system.students.manager.teacher_services.Teacher_services;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class Login_Controller {

    @Autowired
    private Teacher_services teacher_services;

      @Autowired
    private Assigment_services assigment_services; 

    @Autowired
    private Student_service student_service;


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
   
     //checked for teachers login only
    @GetMapping("/user/dashboard")
    public String Dashboard(Model model, Principal principal) {
        String username = principal.getName();
        Teacher_model teacher_model = teacher_services.findByUsername(username);
        List<StudentAssignment> assignments = assigment_services.getAllAssignments();
       
         model.addAttribute("teacher", teacher_model);   
        model.addAttribute("assignments", assignments); 
            return "teacher_dashboard";
            
    }

    ////////////////////////////////////////////////////////////////////////////////////////

     //checked
  
     
     //checked
     @GetMapping("/logout")
     public String logout() {
         // Add code to invalidate session or clear authentication
         return "redirect:/home";
     }
 

}
