package com.system.students.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Principal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.model.StudentAssignment;
import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Teacher_repo;
import com.system.students.manager.security.Password_Coder;
import com.system.students.manager.teacher_services.Teacher_services;

import jakarta.validation.Valid;

@Controller
public class Teacher_Controller {

    @Autowired
    private Teacher_services teacher_services;

    @Autowired
    private Password_Coder password_Coder;

    @Autowired
    private Teacher_repo teacher_repo;

    ////////////////////// DASH BOARD CONTROLLER////////////////////////
   @GetMapping("/admin/dashboard")
    public String adminPage() {
        return "admin_page";
    }
    
    @GetMapping("/teachers/dashboard")
    public String dashboard(Model model, Principal principal) {
        String username = principal.getName();
        Teacher_model teacher_model = teacher_repo.findByUsername(username);
        model.addAttribute("teacher", teacher_model) ;
        return "teacher_dashboard";
    }

/////////////////////////TEACHER CONTROLLER/////////////////////////////////////////

    //checked
    @PostMapping("/teachers/reg")
    public String saveTeacher(@ModelAttribute("teachers") Teacher_model teacher, Model model) {
        teacher.setPassword(password_Coder.encode(teacher.getPassword()));
        teacher_services.save_teacher(teacher);
        return "redirect:/teachers/page";
    }

    //checked
    @GetMapping("/teachers/page")
    public String getAllTeachers(Model model) {
        List<Teacher_model> teachers = teacher_services.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teacher_page_list";
    }

///////////// teachers Dashboard logout & login ///////////////////////////

    //checked
    @GetMapping("/teachers/login")
    public String showLoginPage(Model model) {
        model.addAttribute("teachers", new Teacher_model());
        return "Teacher_Login-Page";
    }
    
    //checked
    @GetMapping("/logout")
    public String logout() {
        // Add code to invalidate session or clear authentication
        return "redirect:/home";
    }

   
///////////////////// teacher profile controllers////////////////////////////////////////////////////////////

    @GetMapping("/teachers/profile")
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher_model teacher = teacher_services.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_profile";
    }

    @GetMapping("/teachers/profile/edit")
    public String editProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Teacher_model teacher = teacher_repo.findByUsername(username);
        model.addAttribute("teacher", teacher);
        return "teacher_edit";
    }

    @PostMapping("/teachers/profile/edit")
    public String updateProfile(@Valid @ModelAttribute("teacher") Teacher_model teacher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "teacher_profile_edit";
        }
        teacher_services.update_teacher(teacher);
        return "redirect:/teachers/profile";
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

    //checked  fix duplicate save
   // @PostMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, @ModelAttribute("teacher") Teacher_model teacher_model) {
        teacher_model.setId(id);
        teacher_services.save_teacher(teacher_model);
        return "redirect:/dashboard";
    }
/////////////////////////////////////////////////////////////////////////////////////
   
    @GetMapping("teachers/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Long id, Model model) {
       teacher_services.delete_teacher(id);
       return "redirect:/teachers/page";
        //return "redirect:/students/page";
    }

}
