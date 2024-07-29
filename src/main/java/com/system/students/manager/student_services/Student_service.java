package com.system.students.manager.student_services;

import java.util.List;
import java.util.Optional;

import com.system.students.manager.model.Students_Model;

public interface Student_service {
    List<Students_Model> getAllStudents();
    Students_Model save_student(Students_Model students_Model);
    Students_Model update_student(Students_Model students_Model);
    void delete_student(Long id);
    Optional<Students_Model> find_by_id(long id);

    


}
