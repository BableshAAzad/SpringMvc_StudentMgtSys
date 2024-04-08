package com.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.entity.Student;

@Repository
public class StudentRepository {
	public static EntityManager getEntityManager() {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentdb");
		  EntityManager em = emf.createEntityManager();
		  return em;
	  }
	
  public void addStudent(Student s) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  em.persist(s);
	  
	  etx.commit();
	  em.close();
  }
  
  public List<Student> displayAllStudents(){
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  Query q = em.createQuery("from Student");
	  List<Student> list = q.getResultList();
	  
	  etx.commit();
	  em.close();
	  return list;
  }
  
  public Student findStudentById(int studentId) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  Student student = em.find(Student.class, studentId);
	  etx.commit();
	  em.close();
	  return student;
  }
  
  public void updateStudent(Student student) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  em.merge(student);
	  
	  etx.commit();
	  em.close();
  }
  
  public void deleteStudentById(int studentId) {
	  EntityManager em = StudentRepository.getEntityManager();
	  EntityTransaction etx = em.getTransaction();
	  etx.begin();
	  
	  Query query = em.createQuery("delete from Student s where s.studentId = :sid");
	  query.setParameter("sid", studentId);
	  int res =  query.executeUpdate();
	  System.out.println(res);
	  
	  etx.commit();
	  em.close();
  }
}
