package com.system.students.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.students.manager.model.User_Model;

public interface User_repo extends JpaRepository<User_Model, Long>{

    User_Model findByUsername(String username);
    //List<Teacher_model> findById(long id);

}
