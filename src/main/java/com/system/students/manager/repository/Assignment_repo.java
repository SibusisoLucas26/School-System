package com.system.students.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.students.manager.model.StudentAssignment;

@Repository
public interface Assignment_repo extends JpaRepository<StudentAssignment, Long> {
    
    List<StudentAssignment> findByStudentId(Long studentId);
    List<StudentAssignment> findByTeacherId(Long teacherId);
   // List<StudentAssignment> findBySubjectId(Long subjectId);
}
