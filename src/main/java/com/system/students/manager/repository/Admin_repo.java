package com.system.students.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.students.manager.model.Admin_model;

@Repository
public interface Admin_repo extends JpaRepository <Admin_model,Long>{

    Admin_model findByUsername(String username);
   // Admin_model findBYPassword(String password);
}
