package com.system.students.manager.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = " Teachers")
public class Teacher_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_name", nullable = false)
    private String last_name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    
    
    @Column(name = "major",nullable = false)
    private String major;
       
    @Column(name = "email", nullable = false)
    private String email;

    // relationship
     @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
    ///////////////// mapped to school model;

    
    @OneToMany(mappedBy = "teacher")
    private List<Class> classes;
    ////////////// mapped to class model

    @OneToMany(mappedBy = "teacher")
    private List<StudentAssignment> assignments;
    //////////// mapped to STudentAssignment model

    @OneToMany(mappedBy = "teacher")
    private List<com.system.students.manager.model.Message> massage;

    @OneToMany(mappedBy = "teacher")
    private List<ScheduleSlot> schedule;
    /////////// mapped to ScheduleSLOT model  
 
    // all getters and setters 
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<StudentAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<StudentAssignment> assignments) {
        this.assignments = assignments;
    }

    public List<com.system.students.manager.model.Message> getMassage() {
        return massage;
    }

    public void setMassage(List<com.system.students.manager.model.Message> massage) {
        this.massage = massage;
    }

    public List<ScheduleSlot> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<ScheduleSlot> schedule) {
        this.schedule = schedule;
    }

    ///consructor of teacher info

    public Teacher_model(long id, String first_name, String last_name, String surname, String username, String password,
            String major, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.major = major;
        this.email = email;
    }

    

     
    
    
}
