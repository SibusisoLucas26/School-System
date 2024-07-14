package com.system.students.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.students.manager.model.Students_Model;

public interface Student_repo extends JpaRepository <Students_Model, Long> {

}
