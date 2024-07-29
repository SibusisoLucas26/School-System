package com.system.students.manager.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.StudentAssignment;
import com.system.students.manager.model.Students_Model;
import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.student_services.Student_service;
import com.system.students.manager.teacher_services.Teacher_services;

@Controller
//@RequestMapping("/admin")
public class Admin_Controller {

    @Autowired
    private Teacher_services teacher_services;

    @Autowired
    private Student_service student_service;

    

//////////////////  admin students CRUD controllers  ///////////////////////

    // checked
    @GetMapping("students/page")
    public String listStudents(Model model) {
        List<Students_Model> students = student_service.getAllStudents();
        model.addAttribute("students", students);
        return "student_page_list";
    }

    @GetMapping("/admin/students/edit/{id}")
    public String edit_Profile(@PathVariable Long id,Model model) {
    // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     //String username = authentication.getName();
     //Teacher_model teacher = teacher_services.findByUsername(username);
     Optional<Students_Model> students_Model = student_service.find_by_id(id);
     model.addAttribute("student", students_Model);
     return "admin_students_form";

    }
    // checked
    @GetMapping("/admin/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        student_service.delete_student(id);
        return "redirect:/students/page";
    }

    // checked
    @PostMapping("/admin/students/reg")
    public String registerStudent(@ModelAttribute Students_Model students) {
        student_service.save_student(students);
        // Logic to save the student
        return "redirect:/students/page";
    }

    // checked
    @GetMapping("/admin/students/new")
        public String new_student(Model model){
            model.addAttribute("students", new Students_Model());
            //stu_service.save_student(student_model);
            return "create_student_form";
    }





/////////////////   admin teachers CRUD controllers ////////////////////////
   // checked
   @GetMapping("/admin/teachers/edit/{id}")
   public String editProfile(Model model, @PathVariable Long id) {
       Optional<Teacher_model> teacher = teacher_services.get_byId(id);
       if (teacher.isPresent()) {
           model.addAttribute("teachers", teacher.get());
       } else {
           // handle the case where the teacher is not found
           return "error"; // or any other error page
       }
       return "admin_teacher_form";
   }

   // checked
   @PostMapping("/admin/teachers/edit")
   public String updateTeacher(@ModelAttribute("teacher") Teacher_model teacher) {
       teacher_services.update_teacher(teacher);
       return "redirect:/teachers/page";
   }

   // checked
   @GetMapping("/admin/teachers/delete/{id}")
   public String deleteTeacher(@PathVariable Long id) {
       teacher_services.delete_teacher(id);
       return "redirect:/admin/teachers";
   }
///////////////////////////////////////////////////////////////////////////////////////////



}
