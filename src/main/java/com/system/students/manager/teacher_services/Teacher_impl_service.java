package com.system.students.manager.teacher_services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Class_repo;
import com.system.students.manager.repository.Teacher_repo;

@Service
public class Teacher_impl_service implements Teacher_services, UserDetailsService {
    
    @Autowired
    private Class_repo class_repo;

    public List<com.system.students.manager.model.Class> findClassesByTeacherId(Long teacherId) {
        return class_repo.findByTeacherId(teacherId);
    }

    ////////////////////////////////////////////
    @Autowired
    private Teacher_repo teacher_repo;
    

    @Override
    public Teacher_model save_teacher(Teacher_model teacher_model) {
        // TODO Auto-generated method stub
        return teacher_repo.save(teacher_model);
       // throw new UnsupportedOperationException("Unimplemented method 'save_teacher'");
    }

    @Override
    public List<Teacher_model> getAllTeachers() {
        // TODO Auto-generated method stub
        return teacher_repo.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getAllTeachers'");
    }

    
    @Override
    public void delete_teacher(Long id) {
        // TODO Auto-generated method stub
        teacher_repo.deleteById(id);
       //System.out.println();
       // throw new UnsupportedOperationException("Unimplemented method 'delete_teacher'");
    }

	

    @Override
    public Teacher_model findByUsername(String username) {
        return teacher_repo.findByUsername(username);
    }

   
    /////////////////// security implimentstion

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher_model teacher_model = teacher_repo.findByUsername(username);
        if (teacher_model == null){
            throw new UsernameNotFoundException("User not founf" + username);
        }
        return org.springframework.security.core.userdetails.User.builder()
                .username(teacher_model.getUsername())
                .password(teacher_model.getPassword())
                .build();
    }
    //////////////////////////////////

    @Override
	public Teacher_model update_teacher(Teacher_model teacher_model) {
		// TODO Auto-generated method stub
        Optional<Teacher_model> teacher_Optional = teacher_repo.findById(teacher_model.getId());
     
      if(teacher_Optional.isPresent()){
        Teacher_model teacher = teacher_Optional.get();
        teacher.setId(teacher_model.getId());
        teacher.setFirst_name(teacher_model.getFirst_name());
        teacher.setLast_name(teacher_model.getLast_name());
        teacher.setUsername(teacher_model.getUsername());
        teacher.setPassword(teacher_model.getPassword());
        teacher.setEmail(teacher_model.getEmail());
        //teacher.setPhone(teacher_model.getPhone());

		return teacher_repo.save(teacher_model);
    } else{
        throw new IllegalArgumentException("teacher not found");
    }
	}

    @Override
    public Optional<Teacher_model> get_byId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get_byId'");
    }
 

   
}
   
