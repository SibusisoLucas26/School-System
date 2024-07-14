package com.system.students.manager.student_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.students.manager.model.Students_Model;
import com.system.students.manager.repository.Student_repo;

@Service
public class Student_implemented_interface implements Student_service {

    @Autowired
    private Student_repo student_repo;

    @Override
    public Students_Model save_student(Students_Model students_Model) {
        // TODO Auto-generated method stub
        return student_repo.save(students_Model);
    }

    @Override
    public Optional<Students_Model> find_by_idNumber(long id_number) {
        // TODO Auto-generated method stub
        return student_repo.findById(id_number);
       
    }
    

    @Override
    public Students_Model update_student(Long id, Students_Model students_Model) {
        // TODO Auto-generated method stub
        students_Model.setId(id);
       return student_repo.save(students_Model);
       // throw new UnsupportedOperationException("Unimplemented method 'edit_student'");
    }

    @Override
    public void delete_student(Long id) {
        student_repo.deleteById(id);
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'delete_student'");
    }

    @Override
    public List<Students_Model> getAllStudents() {
        // TODO Auto-generated method stub
        return student_repo.findAll();
       // throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }



}
