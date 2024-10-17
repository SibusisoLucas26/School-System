 package com.system.students.manager.user_services;

import java.util.List;
import java.util.Optional;

import com.system.students.manager.model.User_Model;

public interface User_Interface {

	//Teacher_model save_teacher(Teacher_model teacher_model);
	List<User_Model> getAllTeachers();
	void delete_teacher(Long id );
	User_Model update_teacher(User_Model teacher_model);
	Optional <User_Model> get_byId(Long id);
    User_Model findByUsername(String username);
    Optional<User_Model> findByTeacherId(Long id);
    User_Model save(User_Model teacher_model);


}
