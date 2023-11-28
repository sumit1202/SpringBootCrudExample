package com.example.springcrud.springcrudexample;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

import com.example.springcrud.springcrudexample.dao.StudentDAO;
import com.example.springcrud.springcrudexample.entity.Student;

@SpringBootApplication
public class SpringcrudexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcrudexampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			// createStudent(studentDao);
			createMultipleStudent(studentDao);
			// readStudent(studentDao);
			// queryForStudents(studentDao);
			// queryForStudentsByLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudent(studentDao);
		};
	}

	private void deleteAllStudent(StudentDAO studentDao) {
		System.out.println("deleting all students...");
		int numRowsDeleted = studentDao.deleteAllStudent();
		System.out.println(numRowsDeleted + " rows deleted.");
	}

	private void deleteStudent(StudentDAO studentDao) {
		int studentId = 6;
		System.out.println("deleting student with id " + studentId + "...");
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDao) {
		// retrieve student by id
		int studentId = 6;
		System.out.println("retrieving student with id " + studentId + "...");
		Student tempStudent = studentDao.findStudentById(studentId);

		// change last name as "Scooby"
		System.out.println("updating last name as \"Scooby\"");
		tempStudent.setFirstName("Scooby");

		// update student
		studentDao.update(tempStudent);

		// display updated student
		System.out.println("Updated student details: " + tempStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDao) {
		// get a list of students
		List<Student> students = studentDao.findStudentsByLastName("Mouse");
		// display a list of students
		for (Student item : students) {
			System.out.println(item);
		}
	}

	private void queryForStudents(StudentDAO studentDao) {
		// get a list of students
		List<Student> students = studentDao.findAllStudent();
		// display a list of students
		for (Student item : students) {
			System.out.println(item);
		}
	}

	private void readStudent(StudentDAO studentDao) {
		// create student object
		System.out.println("creating the new student object...");
		Student tempStudent = new Student("Mini", "Mouse", "mini.mouse@email.com");

		// save student object
		System.out.println("saving the student object...");
		studentDao.saveStudent(tempStudent);

		// display id of the saved student object
		int theId = tempStudent.getId();
		System.out.println("saved student object, generated id is => " + theId);

		// retrieve student object based on the id
		System.out.println("retrieving the student object with id " + theId + "...");
		Student myStudent = studentDao.findStudentById(theId);

		// display the student object
		System.out.println("Found student object: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDao) {
		// create student objects
		System.out.println("creating 3 new student object...");
		Student tempStudent1 = new Student("Dodo", "Jojo", "dodo.jojo@email.com");
		Student tempStudent2 = new Student("Deepa", "Soni", "deepa.soni@email.com");
		Student tempStudent3 = new Student("Chota", "Don", "chota.don@email.com");

		// save student objects
		System.out.println("saving 3 new student object...");
		studentDao.saveStudent(tempStudent1);
		studentDao.saveStudent(tempStudent2);
		studentDao.saveStudent(tempStudent3);

	}

	private void createStudent(StudentDAO studentDao) {
		// create student object
		System.out.println("creating 3 students object...");
		Student tempStudent = new Student("Sumit", "Kumar", "sumitkumar@email.com");

		// save student object
		System.out.println("saving the student object...");
		studentDao.saveStudent(tempStudent);

		// display id of the saved student object
		System.out.println("saved student object generated id is => " + tempStudent.getId());
	}

}
