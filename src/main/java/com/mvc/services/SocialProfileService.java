package com.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.SocialProfile;
import com.mvc.repository.SocialProfileRepository;

@Service
public class SocialProfileService {
	@Autowired
	private SocialProfileRepository socialProfileRepository;

	public ModelAndView addProfile(int studentId, int profileId, String profileName, String url) {
		socialProfileRepository.addProfile(studentId, profileId, profileName, url);
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.addObject("studentId", studentId);
		modelAndView.setViewName("displayAllProfiles.jsp");
		return modelAndView;
	}

	public ModelAndView displayAllProfiles(int studentId) {
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.addObject("studentId", studentId);
		modelAndView.setViewName("displayAllProfiles.jsp;");
		return modelAndView;
	}

	public ModelAndView deleteProfileById(int profileId, int studentId) {
		socialProfileRepository.deleteProfileById(profileId, studentId);
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.addObject("studentId", studentId);
		modelAndView.setViewName("displayAllProfiles.jsp");
		return modelAndView;
	}

	public ModelAndView updateProfile(int profileId, int studentId) {
		SocialProfile sp = socialProfileRepository.updateProfile(profileId, studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("sp", sp);
		modelAndView.addObject("studentId", studentId);
		modelAndView.setViewName("updateProfile.jsp");
		return modelAndView;
	}

	public ModelAndView updateProfileData(int studentId, int profileId, String profileName, String url) {
		socialProfileRepository.updateProfileData(studentId, profileId, profileName, url);
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.addObject("studentId", studentId);
		modelAndView.setViewName("displayAllProfiles.jsp");
		return modelAndView;
	}

}
