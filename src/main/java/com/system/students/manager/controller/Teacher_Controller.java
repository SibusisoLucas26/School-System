package com.system.students.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Teacher_repo;

import com.system.students.manager.teacher_services.Teacher_services;

@Controller
public class Teacher_Controller {

    @Autowired
    private Teacher_services teacher_services;

  
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Teacher_repo teacher_repo;


/////////////////////////TEACHER CONTROLLER/////////////////////////////////////////

    //checked 
    @PostMapping("/teachers/reg")
    public String saveTeacher(@ModelAttribute("teachers") Teacher_model teacher, Model model) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacher_repo.save(teacher);
        return "redirect:/teachers/page";
    }

    //checked
    @GetMapping("/teachers/page")
    public String getAllTeachers(Model model) {
        List<Teacher_model> teachers = teacher_services.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher_page_list";
    }

   
///////////////////// teacher profile controllers//////////////////////////////////////////////////

    @GetMapping("/teachers/profile")
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher_model teacher = teacher_services.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_profile";
    }

    /// teachers profile edit controllers POST & GETMAPPING
    @GetMapping("/teachers/profile/edit")
    public String editProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher_model teacher = teacher_repo.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_edit";
    }

    //checked  fix duplicate save
    @PostMapping("/teachers/profile/edit")
    public String editTeacherForm( @ModelAttribute("teacher") Teacher_model teacher_model) {
                teacher_repo.save(teacher_model);
        return "redirect:/teachers/dashboard";
    }
     

////////////////////////////////////////////////////////////////////////////////////////////////////

    //checked
    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher_model());
        return "create_teacher_form";
    }

    //////////////////////////////////////////////////////////////////////////////////
    // checked 
     @GetMapping("/teachers/edit/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        Optional<Teacher_model> teacher = teacher_services.get_byId(id);
        model.addAttribute("teacher",teacher );
       // return "teacher_edit";
       return "create_teacher_form";
    }

    
/////////////////////////////////////////////////////////////////////////////////////
   
    //checked
    @GetMapping("teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id, Model model) {
       teacher_services.delete_teacher(id);
       return "redirect:/teachers/page";
        //return "redirect:/students/page";
    }

}
