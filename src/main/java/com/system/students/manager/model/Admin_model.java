package com.system.students.manager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username ;
    private String password;

    public String getUsername() {
        return username;
    }
    public String setUsername(String username) {
        return this.username = username;
    }
    public String getPassword(String string) {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

////////////////////////////// contructor


    public Admin_model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Admin_model(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public Admin_model() {
    }

    @Override
    public String toString() {
        return "Admin_model [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
    


///////////////////////////////////////////////
    

    
    
    

}
