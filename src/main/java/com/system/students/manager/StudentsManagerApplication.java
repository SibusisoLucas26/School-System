package com.system.students.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.students.manager.model.Students_Model;
import com.system.students.manager.model.Teacher_model;
import com.system.students.manager.repository.Student_repo;
import com.system.students.manager.repository.Teacher_repo;

@SpringBootApplication
public class StudentsManagerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentsManagerApplication.class, args);

		
		
	}

	@Autowired
	private Teacher_repo teacher_repo;

	@Autowired
	private Student_repo student_repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub


		// teacher demo data

		Teacher_model model_one = new Teacher_model(1, "sibusiso", "lucas", "mbanjwa", "mabura", "mabura", "math","lucas@gmail.com");
		teacher_repo.save(model_one);

		Teacher_model model_two = new Teacher_model(2, "thabani", "mike", "gumbi", "gumbi", "gumbi", "history","gumbi@gmail.com");
		teacher_repo.save(model_two);

		// student demo data

		Students_Model student_one = new Students_Model(1, "zikho", "john", "mkhize","1999/06/09", "male", "france",45674754,"gumbi@gmail.com","zinhle mkhize", 0675432456, "science");
		student_repo.saveAndFlush(student_one);

		

		//throw new UnsupportedOperationException("Unimplemented method 'run'");
	}

}
