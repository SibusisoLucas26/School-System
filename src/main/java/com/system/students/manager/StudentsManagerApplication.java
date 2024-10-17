package com.system.students.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.students.manager.Assigment_Services.Assigment_services;
import com.system.students.manager.model.Assignment;
import com.system.students.manager.model.Students_Model;
import com.system.students.manager.repository.Assignment_repo;
import com.system.students.manager.repository.Student_repo;

@SpringBootApplication
public class StudentsManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentsManagerApplication.class, args);
    }

    @Autowired
    private Student_repo student_repo;

    @Autowired
    private Assigment_services assignment_services;

    @Autowired
    private Assignment_repo assignment_repo;

    @Override
    public void run(String... args) throws Exception {

        if (assignment_repo.count() == 0) {
            Assignment assignment1 = new Assignment();
            assignment1.setTitle("Math");
            assignment1.setDescription("Test on algebra");
            assignment1.setDueDate("October 17");

            Assignment assignment2 = new Assignment();
            assignment2.setTitle("Biology");
            assignment2.setDescription("Quiz on plant cells");
            assignment2.setDueDate("October 18");

            assignment_services.saveAssignment(assignment1);
            assignment_services.saveAssignment(assignment2);

            System.out.println("Sample assignments saved to the database.");
        }

        // TODO Auto-generated method stub
        Students_Model students_Model = new Students_Model();
        students_Model.setFirstName("sibusiso");
        students_Model.setLastName("lucas");
        students_Model.setSurname("mbanjwa");
        students_Model.setDate_of_birth("1998/10/26");
        students_Model.setGender("male");
        students_Model.setAddress("france");
        students_Model.setId_number("9810265794082");
        students_Model.setEmail("sbu@gmail.com");
        students_Model.setParent_name("thabo");
        students_Model.setParent_contact("0761351805");
        students_Model.setSubjects("grade 9");
        student_repo.save(students_Model);
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
