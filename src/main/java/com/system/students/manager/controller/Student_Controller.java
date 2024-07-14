package com.system.students.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.system.students.manager.model.Students_Model;
import com.system.students.manager.student_services.Student_implemented_interface;

@Controller
//@RequestMapping("/teacher")
public class Student_Controller {
    
   
    @Autowired
    private Student_implemented_interface stu_service;

////////////////////// HOME CONTROLLER//////////////////////////////
    @GetMapping("/home")
    public String index() {
        return "index";
    }    



///////////////////// STUDENT CONTROLER ////////////////

    @GetMapping("students/page")
    public String listStudents(Model model) {
        List<Students_Model> students = stu_service.getAllStudents();
        model.addAttribute("students", students);
        return "student_page_list";
    }

    
    @GetMapping("students/academic")
    public String showStudentAcademicForm(Model model) {
        return "student_academic_form";
    }

    @PostMapping("/academic")
    public String saveStudentInfo(@ModelAttribute("students") Students_Model students) {
        // Logic to save the student
        // For example, studentRepository.save(students);
        stu_service.save_student(students);
        return "redirect:/student/academic"; // Redirect to a page that lists all students
    }

    @GetMapping("students/new")
        public String new_student(Model model){
            model.addAttribute("students", new Students_Model());
            //stu_service.save_student(student_model);
            return "create_student_form";        
    }

    
    @GetMapping("students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Optional<Students_Model> students_Model = stu_service.find_by_idNumber(id);
        model.addAttribute("student", students_Model);
        return "students/edit";
    }

    @PostMapping("students/reg")
    public String registerStudent(@ModelAttribute Students_Model students) {
        stu_service.save_student(students);
        // Logic to save the student
        return "redirect:/students/page";
    }

    @PostMapping("students/{id}")
    public String update_students(@PathVariable("id") Long id,
     @ModelAttribute("students") Students_Model students_Model){
        stu_service.update_student(id, students_Model);
        return "redirect:/students_page_list";
     }

     @GetMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model) {
        stu_service.delete_student(id);
        return "redirect:/students/page";
    } 

}
