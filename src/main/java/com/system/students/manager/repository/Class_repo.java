package com.system.students.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.students.manager.model.Class;

public interface Class_repo extends JpaRepository<Class, Long> {
    List<Class> findByTeacherId(Long teacherId);

}
