package com.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.Student;
import com.mvc.repository.StudentRepository;

@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;

	public ModelAndView addStudent(Student s) {
		studentRepository.addStudent(s);
		ModelAndView modelAndView = new ModelAndView();
		List<Student> list = studentRepository.displayAllStudents();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("displayAllStudent.jsp");
		return modelAndView;
	}

	public ModelAndView displayAllStudents() {
		List<Student> list = studentRepository.displayAllStudents();
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("list", list);
		modelAndView.setViewName("displayAllStudent.jsp");
		return modelAndView;
	}
	public ModelAndView findStudentById(int studentId) {
		Student student = studentRepository.findStudentById(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("updateStudent.jsp");
		return modelAndView;
	}

	public ModelAndView updateStudent(Student student) {
		studentRepository.updateStudent(student);
		List<Student> list = studentRepository.displayAllStudents();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("displayAllStudent.jsp");
		return modelAndView;
	}
	
	public ModelAndView deleteStudentById(int studentId) {
//		Student student = studentRepository.findStudentById(studentId);
//		studentRepository.deleteStudentById(student);
		studentRepository.deleteStudentById(studentId);
		List<Student> list = studentRepository.displayAllStudents();
		return new ModelAndView("displayAllStudent.jsp").addObject("list",list);
	}
}
