package com.system.students.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.students.manager.model.Teacher_model;

public interface Teacher_repo extends JpaRepository<Teacher_model, Long>{

    Teacher_model findByUsername(String username);
    //List<Teacher_model> findById(long id);

}
