package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.SocialProfile;
import com.mvc.services.SocialProfileService;

@Controller
public class SocialProfileController {
	@Autowired
	private SocialProfileService socialProfileService;

	@RequestMapping(value = "/addNewProfile", method = RequestMethod.POST)
	public ModelAndView addProfile(@RequestParam int studentId, @RequestParam int profileId,
			@RequestParam String profileName, @RequestParam String url) {
		return socialProfileService.addProfile(studentId, profileId, profileName, url);
	}

	@RequestMapping(value = "/addProfilePage", method = RequestMethod.GET)
	public ModelAndView addNewProfile(@RequestParam int studentId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addNewProfile.jsp");
		modelAndView.addObject("studentId", studentId);
		return modelAndView;
	}

	@RequestMapping(value = "/displayAllProfiles", method = RequestMethod.GET)
	public ModelAndView displayAllProfiles(@RequestParam int studentId) {
		return socialProfileService.displayAllProfiles(studentId);
	}

	@RequestMapping(value = "/deleteProfile", method = RequestMethod.GET)
	public ModelAndView deleteProfileById(@RequestParam int profileId, @RequestParam int studentId) {
		return socialProfileService.deleteProfileById(profileId, studentId);
	}

	@RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
	public ModelAndView updateProfile(@RequestParam int profileId, @RequestParam int studentId) {
		return socialProfileService.updateProfile(profileId, studentId);
	}

	@RequestMapping(value = "/updateProfileData", method = RequestMethod.POST)
	public ModelAndView updateProfileData(@RequestParam int studentId, @RequestParam int profileId,
			@RequestParam String profileName, @RequestParam String url) {
		return socialProfileService.updateProfileData(studentId, profileId, profileName, url);
	}
}
