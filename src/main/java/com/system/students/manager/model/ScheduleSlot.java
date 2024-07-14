package com.system.students.manager.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ScheduleSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day;

    private LocalTime startTime;

    private LocalTime endTime;

    //@Repeatable
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher_model teacher;

    // Getters and Setters
}
