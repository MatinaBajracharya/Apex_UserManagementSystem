package com.usermgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.usermgmt.form.RegistrationForm;
import com.usermgmt.service.RegistrationService;

@Controller
@RequestMapping("/app")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	@RequestMapping("/submit")
	public ModelAndView submitForm(@ModelAttribute("registrationForm") RegistrationForm registrationForm) {
		boolean isSame = registrationService.isPasswordAndConfirmPasswordSame(registrationForm);
		if (!isSame) {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("error", "Passwords do not match");
			return mav;
		} else {
			ModelAndView mav = new ModelAndView("index");
			return mav;
		}

	}

}
