package com.system.students.manager.user_services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.students.manager.model.User_Model;
import com.system.students.manager.repository.User_repo;

@Service
public class User_Service implements User_Interface {

    ////////////////////////////////////////////
    @Autowired
    private User_repo user_repo;

    /////////////////////////////////////////////////////////////

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String firstname, String lastname, String surname, String username, String password,
            Set<String> roles) {
        User_Model teacher_model = new User_Model(firstname, lastname, surname, username,
                passwordEncoder.encode(password), roles);
        user_repo.save(teacher_model);
    }
    //////////////////////////////////////////////////

    @Override
    public List<User_Model> getAllTeachers() {
        // TODO Auto-generated method stub
        return user_repo.findAll();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getAllTeachers'");
    }

    @Override
    public void delete_teacher(Long id) {
        // TODO Auto-generated method stub
        user_repo.deleteById(id);
        // System.out.println();
        // throw new UnsupportedOperationException("Unimplemented method
        // 'delete_teacher'");
    }

    @Override
    public User_Model findByUsername(String username) {
        return user_repo.findByUsername(username);
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
    public User_Model update_teacher(User_Model teacher_model) {
        // TODO Auto-generated method stub
        Optional<User_Model> teacher_Optional = user_repo.findById(teacher_model.getId());

        if (teacher_Optional.isPresent()) {
            User_Model teacher = teacher_Optional.get();
            teacher.setId(teacher_model.getId());

            teacher.setUsername(teacher_model.getUsername());
            teacher.setPassword(teacher_model.getPassword());

            // teacher.setPhone(teacher_model.getPhone());

            return user_repo.save(teacher_model);
        } else {
            throw new IllegalArgumentException("teacher not found");
        }
    }

    @Override
    public Optional<User_Model> get_byId(Long id) {
        // TODO Auto-generated method stub
        return user_repo.findById(id);
        // throw new UnsupportedOperationException("Unimplemented method 'get_byId'");
    }

    @Override
    public Optional<User_Model> findByTeacherId(Long id) {
        // TODO Auto-generated method stub
        return user_repo.findById(id);
        // throw new UnsupportedOperationException("Unimplemented method
        // 'findByTeacherId'");
    }

    @Override
    public User_Model save(User_Model teacher_model) {
        // TODO Auto-generated method stub
        return user_repo.save(teacher_model);
        // throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
