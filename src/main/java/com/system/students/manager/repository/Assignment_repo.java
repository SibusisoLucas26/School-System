package com.system.students.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.students.manager.model.Assignment;

@Repository
public interface Assignment_repo extends JpaRepository<Assignment, Long> {
    // List<Assignment> findByStudentId(Long studentId);
    // List<Assignment> findByTeacherId(Long teacherId);
    // List<StudentAssignment> findBySubjectId(Long subjectId);
}
