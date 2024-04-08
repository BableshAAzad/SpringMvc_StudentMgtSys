package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.Student;
import com.mvc.services.StudentServices;

@Controller
public class StudentController {
	@Autowired
	private StudentServices studentServices;

	@RequestMapping(value = "/studentAdd", method = RequestMethod.POST)
	public ModelAndView addStudent(Student student) {
		ModelAndView modelAndView = studentServices.addStudent(student);
		return modelAndView;
	}

	@RequestMapping(value = "/displayAllStudent", method = RequestMethod.GET)
	public ModelAndView displayAllStudents() {
		return studentServices.displayAllStudents();
	}

	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public ModelAndView findStudentById(@RequestParam int studentId) {
	    return studentServices.findStudentById(studentId);
	}

	@RequestMapping(value = "/saveUpdatedStudent", method = RequestMethod.POST)
	public ModelAndView updateStudent(Student student) {
		return studentServices.updateStudent(student);
	}

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudentById(@RequestParam int studentId) {
		return studentServices.deleteStudentById(studentId);
	}

}
