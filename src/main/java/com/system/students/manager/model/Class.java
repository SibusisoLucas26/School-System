package com.system.students.manager.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

   

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher_model teacher;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<StudentAssignment> assignments;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ScheduleSlot> schedule;

    public Class(Long id, String name, Teacher_model teacher) {
        this.id = id;
        this.name = name;
       
        this.teacher = teacher;
    }


}
