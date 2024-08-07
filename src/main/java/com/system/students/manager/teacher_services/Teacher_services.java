 package com.system.students.manager.teacher_services;

import java.util.List;
import java.util.Optional;

import com.system.students.manager.model.Teacher_model;

public interface Teacher_services {

	//Teacher_model save_teacher(Teacher_model teacher_model);
	List<Teacher_model> getAllTeachers();
	void delete_teacher(Long id );
	Teacher_model update_teacher(Teacher_model teacher_model);
	Optional <Teacher_model> get_byId(Long id);
    Teacher_model findByUsername(String username);
    Optional<Teacher_model> findByTeacherId(Long id);
    Teacher_model save(Teacher_model teacher_model);


}
