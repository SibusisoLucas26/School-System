package com.system.students.manager.model;

import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentAssignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String dueDate;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher_model teacher;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students_Model student;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentSubmission> submissions;
}
