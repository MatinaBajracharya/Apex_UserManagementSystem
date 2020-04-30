package com.usermgmt.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.usermgmt.form.RegistrationForm;
import com.usermgmt.service.RegistrationService;

@Controller
@RequestMapping("/app")
@Validated
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	@RequestMapping("/submit")
	public ModelAndView submitForm(@ModelAttribute("registrationForm") @Valid RegistrationForm registrationForm,
			BindingResult result) {
		ModelAndView mav = new ModelAndView("register");
		if (result.hasErrors()) {
			return mav;
		} else {
			boolean isSame = registrationService.isPasswordAndConfirmPasswordSame(registrationForm);
			if (!isSame) {
				FieldError fe = new FieldError("registrationForm", "pass1", "");
				FieldError fe2 = new FieldError("registrationForm", "pass2", "");
				result.addError(fe);
				result.addError(fe2);
				return mav;
			} else {
				mav = new ModelAndView("index");
				registrationService.saveUser(registrationForm);
				return mav;
			}
		}	
	}

}
