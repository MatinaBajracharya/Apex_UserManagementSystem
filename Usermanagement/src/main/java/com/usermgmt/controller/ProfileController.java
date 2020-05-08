package com.usermgmt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.usermgmt.model.User;

@Controller
@RequestMapping("/app")
public class ProfileController {

	@RequestMapping("/profile")
	public ModelAndView profile(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = null;
		if (user != null && user.getRole().equalsIgnoreCase("CLIENT")) {
			mav = new ModelAndView("profileClient");
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}

	@RequestMapping("/admin/profile")
	public ModelAndView adminHome(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = null;
		if (user != null && user.getRole().equalsIgnoreCase("ADMIN")) {
			mav = new ModelAndView("profileAdmin");
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}
}
