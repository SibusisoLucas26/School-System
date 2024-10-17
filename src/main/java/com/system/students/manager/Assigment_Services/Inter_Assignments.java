package com.system.students.manager.Assigment_Services;

import java.util.List;
import java.util.Optional;

import com.system.students.manager.model.Assignment;

public interface Inter_Assignments {
    void update(Assignment assignment);

    Assignment saveAssignment(Assignment assignment);

    Optional<Assignment> findById(Long id);

    List<Assignment> getAllAssign();

    void deleteAssign(Long id);
}
