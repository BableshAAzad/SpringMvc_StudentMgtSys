package com.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mvc.entity.SocialProfile;
import com.mvc.entity.Student;

@Repository
public class SocialProfileRepository {

	public void addProfile(SocialProfile socialProfile, int studentId) {
		EntityManager em = StudentRepository.getEntityManager();
		EntityTransaction etx = em.getTransaction();

		em.persist(socialProfile);

		etx.commit();
		em.close();
	}

	public List<SocialProfile> displayAllProfiles(int studentId) {
		EntityManager em = StudentRepository.getEntityManager();
		EntityTransaction etx = em.getTransaction();

//		Query query = em.createQuery("from Student s where s.studentId = :sid");
//		query.setParameter("sid", studentId);
//		Student student = (Student) query.getSingleResult();
		Student student = em.find(Student.class, studentId);
		List<SocialProfile> profileList = student.getSocialProfile();
//		System.out.println(profileList + "=========");
		etx.commit();
		em.close();
		return profileList;
	}
}
