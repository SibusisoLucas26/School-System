package com.system.students.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.model.Students_Model;
import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.student_services.Student_service;
import com.system.students.manager.teacher_services.Teacher_services;

@Controller
// @RequestMapping("/admin")
public class Admin_Controller {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Teacher_services teacher_services;

    @Autowired
    private Student_service student_service;

    ////////////////// admin students CRUD controllers ///////////////////////

    // checkd
    @GetMapping("/admin/students/page")
    public String listStudents(Model model) {
        List<Students_Model> students = student_service.getAllStudents();
        model.addAttribute("students", students);
        return "student_page_list";
    }

    /////////////////////////////////////////////////////// update student
    /////////////////////////////////////////////////////// controlers
    @GetMapping("/admin/students/edit/{id}")
    public String edit_Profile(@PathVariable Long id, Model model) {
        Optional<Students_Model> students_Model = student_service.find_by_id(id);
        if (students_Model.isPresent()) {
            model.addAttribute("students", students_Model.get());
        } else {
            return "student not found";
        }
        return "admin_students_form";

    }

    @PostMapping("/admin/students/edit")
    public String update_students(@ModelAttribute("students") Students_Model students_Model) {
        Optional<Students_Model> exStudent_model = student_service.find_by_id(students_Model.getId());
        if (exStudent_model.isPresent()) {
            Students_Model studentUpdate = exStudent_model.get();
            studentUpdate.setFirstName(students_Model.getFirstName());
            studentUpdate.setLastName(students_Model.getLastName());
            studentUpdate.setId_number(students_Model.getId_number());
            studentUpdate.setAddress(students_Model.getAddress());
            studentUpdate.setDate_of_birth(students_Model.getDate_of_birth());
            studentUpdate.setGender(students_Model.getGender());
            studentUpdate.setParent_name(students_Model.getParent_name());
            studentUpdate.setParent_contact(students_Model.getParent_contact());
            studentUpdate.setSubjects(students_Model.getSubjects());
            student_service.update_student(studentUpdate);

            return "redirect:/admin/students/page";
        } else {
            return "Students_Model is not found";
        }
    }

    //////////////////////////// Teachers
    //////////////////////////// CRUD/////////////////////////////////////////////////
    // checked
    @GetMapping("/admin/teachers/page")
    public String getAllTeachers(Model model) {
        List<Teacher_model> teachers = teacher_services.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher_page_list";
    }

    // checked
    @PostMapping("/admin/students/reg")
    public String registerStudent(@ModelAttribute("students") Students_Model students) {
        student_service.save_student(students);
        // Logic to save the student
        return "redirect:/admin/students/page";
    }

    // checked
    @GetMapping("/admin/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        student_service.delete_student(id);
        return "redirect:/admin/students/page";
    }

    // checked
    @GetMapping("/admin/students/new")
    public String new_student(Model model) {
        model.addAttribute("students", new Students_Model());
        // stu_service.save_student(student_model);
        return "create_student_form";
    }

    ///////////////// admin teachers CRUD controllers ////////////////////////
      // checked
    @PostMapping("/teachers/reg")
    public String saveTeacher(@ModelAttribute("teachers") Teacher_model teacher, Model model) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
      //  teacher_repo.save(teacher);
      teacher_services.save(teacher);
        return "redirect:/admin/teachers/page";
    }
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
        return "redirect:/admin/teachers/page";
    }

    // checked
    @GetMapping("/admin/teachers/delete/{id}")
    public String deleteTeacher(@PathVariable Long id) {
        teacher_services.delete_teacher(id);
        return "redirect:/admin/teachers/page";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

}
