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

	public ModelAndView addProfile(SocialProfile socialProfile, int studentId) {
		socialProfileRepository.addProfile(socialProfile, studentId);
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.setViewName("displayAllProfiles.jsp");
		return modelAndView;
	}

	public ModelAndView displayAllProfiles(int studentId) {
		List<SocialProfile> profileList = socialProfileRepository.displayAllProfiles(studentId);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("profileList", profileList);
		modelAndView.setViewName("displayAllProfiles.jsp;");
		return modelAndView;
	}

//	public List<SocialProfile> displayAllProfiles(int studentId) {
//			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//			List<SocialProfile> displayAllProfiles  = socialProfileRepository.displayAllProfiles(studentId);
//			System.out.println(displayAllProfiles+"  -->-->-->-->-->--><--<==");
//		return displayAllProfiles;
//	}
}
