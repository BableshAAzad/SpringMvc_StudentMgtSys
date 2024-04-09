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

import com.mvc.entity.SocialProfile;
import com.mvc.services.SocialProfileService;

@Controller
public class SocialProfileController {
	@Autowired
	private SocialProfileService socialProfileService;
	
	@RequestMapping(value="/addProfile", method=RequestMethod.POST)
	public ModelAndView addProfile(SocialProfile socialProfile, @RequestParam int studentId) {
		System.out.println(socialProfile);
		return socialProfileService.addProfile(socialProfile, studentId);
	}
	
	@RequestMapping(value="/displayAllProfiles", method=RequestMethod.GET)
	public ModelAndView displayAllProfiles(@RequestParam int studentId) {
		return socialProfileService.displayAllProfiles(studentId);
	}
	
//	@RequestMapping(value="/displayAllProfiles", method=RequestMethod.GET)
//	public void displayAllProfiles(@RequestParam int studentId, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		List<SocialProfile> profileList = socialProfileService.displayAllProfiles(studentId);
//		System.out.println(profileList+" +++++");
//		System.out.println("-----------------------------------");
//		req.setAttribute("profileList", profileList);
//		RequestDispatcher rd = req.getRequestDispatcher("displayAllProfiles.jsp");
//		rd.forward(req, resp);
//	}
}
