package com.mvc.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mvc.entity.SocialProfile;
import com.mvc.entity.Student;

@Repository
public class SocialProfileRepository {

	public void addProfile(int studentId, int profileId, String profileName, String url) {
		Session session = StudentRepository.getSession();
		EntityTransaction tx = session.beginTransaction();

		Student student = session.load(Student.class, studentId);
		List<SocialProfile> listProfiles = student.getSocialProfile();
		
		SocialProfile socialProfile = new SocialProfile();
		socialProfile.setProfileId(profileId);
		socialProfile.setProfileName(profileName);
		socialProfile.setUrl(url);
		socialProfile.setStudent(student);
		
		List<SocialProfile> al = new ArrayList<>();
		al.addAll(listProfiles);
		al.add(socialProfile);
		
		student.setSocialProfile(al);
		session.update(student);
		session.save(socialProfile);
		
		tx.commit();
		session.close();
	}

	public List<SocialProfile> displayAllProfiles(int studentId) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();

		Query<Student> query = session.createQuery("from Student s where s.studentId = :sid");
		query.setParameter("sid", studentId);
		Student student = (Student) query.getSingleResult();
//		Student student = session.get(Student.class, studentId);
		List<SocialProfile> profileList = student.getSocialProfile();
		System.out.println(profileList);
		tx.commit();
		session.close();
		return profileList;
	}

	public void deleteProfileById(int profileId, int studentId) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();
		
		SocialProfile socialProfile = session.load(SocialProfile.class, profileId);
		session.delete(socialProfile);

		Student s = session.load(Student.class, studentId);
		List<SocialProfile> list = s.getSocialProfile();
		list.remove(socialProfile);
		
		s.setSocialProfile(list);
		session.update(s);
		
		tx.commit();
		session.close();
	}

	public SocialProfile updateProfile(int profileId, int studentId) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();
		
		SocialProfile sp = session.find(SocialProfile.class, profileId);
		
		tx.commit();
		session.close();
		return sp;
	}

	public void updateProfileData(int studentId, int profileId, String profileName, String url) {
		Session session = StudentRepository.getSession();
		Transaction tx = session.beginTransaction();
		
		SocialProfile sp = session.find(SocialProfile.class, profileId);
		sp.setProfileName(profileName);
		sp.setUrl(url);
		session.update(sp);
		
		tx.commit();
		session.close();
	}
}
