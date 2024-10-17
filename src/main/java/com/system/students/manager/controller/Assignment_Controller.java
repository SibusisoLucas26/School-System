package com.system.students.manager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.Assignment;

@Controller
public class Assignment_Controller {

    @Autowired
    private Assigment_services assigment_services;

    // @GetMapping("/teachers/dashboard")
    // checked
    // public String getAllAssignments(Model model) {
    // List<StudentAssignment> assignments = assigment_services.getAllAssignments();
    /// model.addAttribute("assignment", assignments);
    // return "teacher_dashboard";
    // }

    // checked
    @GetMapping("assignments/new")
    public String showCreateForm(Model model) {
        model.addAttribute("assignment", new Assignment());
        return "assignment_create";
    }

    // checked
    @GetMapping("/assignments/edit/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        Optional<Assignment> assignment = assigment_services.findById(id);
        model.addAttribute("assignment", assignment);
        return "assignment_edit";
    }

    // checked
    @PostMapping("/assigments/update")
    public String updateAssignment(@ModelAttribute Assignment assignment) {
        assigment_services.update(assignment);
        return "redirect:/user/dashboard";
    }

    // checked
    @GetMapping("/assignments/delete/{id}")
    public String deleteAssignment(@PathVariable Long id) {
        assigment_services.deleteAssign(id);
        return "redirect:/user/dashboard";
    }

    // checked
    @PostMapping("/assignments/save")
    public String createAssignment(@ModelAttribute Assignment assignment) {
        assigment_services.saveAssignment(assignment);
        return "redirect:/user/dashboard";
    }

    /////////////////////////////////////////////
    @GetMapping("/assignment/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = assigment_services.findById(id);
        return assignment
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
