package com.system.students.manager.teacher_services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Class_repo;
import com.system.students.manager.repository.Teacher_repo;

@Service
public class Teacher_impl_service implements Teacher_services {

    @Autowired
    private Class_repo class_repo;

    public List<com.system.students.manager.model.Class> findClassesByTeacherId(Long teacherId) {
        return class_repo.findByTeacherId(teacherId);
    }

    ////////////////////////////////////////////
    @Autowired
    private Teacher_repo teacher_repo;

    /////////////////////////////////////////////////////////////

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String firstname, String lastname, String surname, String username, String password,
            Set<String> roles) {
        Teacher_model teacher_model = new Teacher_model(firstname, lastname, surname, username,
                passwordEncoder.encode(password), roles);
        teacher_repo.save(teacher_model);
    }
    //////////////////////////////////////////////////

    @Override
    public List<Teacher_model> getAllTeachers() {
        // TODO Auto-generated method stub
        return teacher_repo.findAll();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getAllTeachers'");
    }

    @Override
    public void delete_teacher(Long id) {
        // TODO Auto-generated method stub
        teacher_repo.deleteById(id);
        // System.out.println();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'delete_teacher'");
    }

    @Override
    public Teacher_model findByUsername(String username) {
        return teacher_repo.findByUsername(username);
    }

    /////////////////// security implimentstion

    /// @Override
    // public UserDetails loadUserByUsername(String username) throws
    /// UsernameNotFoundException {
    // Teacher_model teacher_model = teacher_repo.findByUsername(username);
    // if (teacher_model == null){
    // throw new UsernameNotFoundException("User not founf" + username);
    // }
    // return org.springframework.security.core.userdetails.User.builder()
    // .username(teacher_model.getUsername())
    // .password(teacher_model.getPassword())
    // .build();
    // }
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////

    @Override
    public Teacher_model update_teacher(Teacher_model teacher_model) {
        // TODO Auto-generated method stub
        Optional<Teacher_model> teacher_Optional = teacher_repo.findById(teacher_model.getId());

        if (teacher_Optional.isPresent()) {
            Teacher_model teacher = teacher_Optional.get();
            teacher.setId(teacher_model.getId());

            teacher.setUsername(teacher_model.getUsername());
            teacher.setPassword(teacher_model.getPassword());

            // teacher.setPhone(teacher_model.getPhone());

            return teacher_repo.save(teacher_model);
        } else {
            throw new IllegalArgumentException("teacher not found");
        }
    }

    @Override
    public Optional<Teacher_model> get_byId(Long id) {
        // TODO Auto-generated method stub
        return teacher_repo.findById(id);
        // throw new UnsupportedOperationException("Unimplemented method 'get_byId'");
    }

    @Override
    public Optional<Teacher_model> findByTeacherId(Long id) {
        // TODO Auto-generated method stub
        return teacher_repo.findById(id);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'findByTeacherId'");
    }

    @Override
    public Teacher_model save(Teacher_model teacher_model) {
        // TODO Auto-generated method stub
        return teacher_repo.save(teacher_model);
       // throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
