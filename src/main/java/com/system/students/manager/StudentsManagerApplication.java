package com.system.students.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.students.manager.model.Students_Model;
import com.system.students.manager.repository.Student_repo;

@SpringBootApplication
public class StudentsManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentsManagerApplication.class, args);

	}

	@Autowired
	private Student_repo student_repo;

	@Override
	public void run(String... args) throws Exception {
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
