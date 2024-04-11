package com.mvc.repository;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.mvc.entity.SocialProfile;
import com.mvc.entity.Student;

@Repository
public class StudentRepository {
	
	public static Session getSession() {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(SocialProfile.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public void addStudent(Student s) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		session.save(s);

		tx.commit();
		session.close();
	}

	public List<Student> displayAllStudents() {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		Query q = session.createQuery("from Student");
		List<Student> list = q.getResultList();

		tx.commit();
		session.close();
		return list;
	}

	public Student findStudentById(int studentId) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		Student student = session.get(Student.class, studentId);

		tx.commit();
		session.close();
		return student;
	}

	public void updateStudent(Student student) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		session.update(student);

		tx.commit();
		session.close();
	}

	public void deleteStudentById(int studentId) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		Student s = session.load(Student.class, studentId);
		List<SocialProfile> list = s.getSocialProfile();
		for(SocialProfile sp : list) {
			session.delete(sp);
		}
		session.delete(s);

		tx.commit();
		session.close();
	}
}
