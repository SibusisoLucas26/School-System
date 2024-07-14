package com.system.students.manager.Assigment_Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.students.manager.model.StudentAssignment;
import com.system.students.manager.repository.Assignment_repo;

@Service
public class Assigment_services {

    @Autowired
    private Assignment_repo assigmeent_repo;

    public List<com.system.students.manager.model.StudentAssignment> getAllAssignments(){
        return assigmeent_repo.findAll();
    } 

    public Optional<com.system.students.manager.model.StudentAssignment> getAssignById(Long id){
        return assigmeent_repo.findById(id);
    }

    public StudentAssignment saveAssignment(StudentAssignment assignment){
        return assigmeent_repo.save(assignment);
    }

    public void deleteAssignment(Long id) {
        assigmeent_repo.deleteById(id);
    }

    public List<StudentAssignment> getAssignmentsByStudentId(Long studentId) {
      return assigmeent_repo.findByStudentId(studentId);
      
    }

    public List<StudentAssignment> getAssignmentsByTeacherId(Long teacherId) {
        return assigmeent_repo.findByTeacherId(teacherId);
    }

    public void updateAssignment(Long id, StudentAssignment updatedAssignment) {
        StudentAssignment existingAssignment =assigmeent_repo.findById(id).orElse(null);
        if (existingAssignment != null) {
            existingAssignment.setTitle(updatedAssignment.getTitle());
            existingAssignment.setDescription(updatedAssignment.getDescription());
            existingAssignment.setDueDate(updatedAssignment.getDueDate());
            // Update other fields as necessary
            assigmeent_repo.save(existingAssignment);
        }
    }

   // public List<StudentAssignment> getAssignmentsBySubjectId(Long subjectId) {
     //   return assigmeent_repo.findBySubjectId(subjectId);
   // }

    }
