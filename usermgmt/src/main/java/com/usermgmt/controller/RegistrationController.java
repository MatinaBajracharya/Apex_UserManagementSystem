package com.usermgmt.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.usermgmt.form.RegistrationForm;
import com.usermgmt.model.User;
import com.usermgmt.service.HistoryService;
import com.usermgmt.service.RegistrationService;
import com.usermgmt.service.UserService;

@Controller
@RequestMapping("/app")
@Validated
public class RegistrationController {

	private final static String ADDED_USER = "ADDED_USER";

	private final static String REGISTERED = "REGISTERED";

	@Autowired
	RegistrationService registrationService;

	@Autowired
	HistoryService historyService;

	@Autowired
	UserService userService;

	/* Displaying the register page. */
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}

	/*
	 * The logged in user's role is checked, if the role is admin, then the adding
	 * new user form is displayed. Else, the user is asked to login if he/she is
	 * directly accessing the page through the URL.
	 */
	@RequestMapping("/newuser")
	public ModelAndView registerNewUser(HttpSession session) {
		ModelAndView mav = null;
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if (loggedInUser != null && loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
			mav = new ModelAndView("newuser");
		} else {
			mav = new ModelAndView("login");
		}
		return mav;
	}

	/*
	 * When logged in user is null, registration form is displayed and upon pressing
	 * submit, all the fields are checked. When logged in user is not null,
	 * registration form is displayed to add new user and upon pressing submit, all
	 * the fields are checked. If the criteria is met, the user is added and history
	 * table is updated.
	 */

	@RequestMapping("/submit")
	public ModelAndView submitForm(@ModelAttribute("registrationForm") @Valid RegistrationForm registrationForm,
			BindingResult result, HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = new ModelAndView("register");
		if (result.hasErrors()) {
			return mav;
		} else {
			boolean isSame = registrationService.isPasswordAndConfirmPasswordSame(registrationForm);
			if (!isSame && loggedInUser != null && loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
				mav = new ModelAndView("newuser");
				mav.addObject("pwMsg", "Passwords do not match");
			} else if (registrationForm.getPass1().length() < 8 && loggedInUser != null
					&& loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
				mav = new ModelAndView("newuser");
				mav.addObject("pwMsg", "Passwords must be atleast 8 characters");
			} else if (loggedInUser == null && registrationForm.getPass1().length() < 8) {
				mav.addObject("pwMsg", "Passwords must be atleast 8 characters");
			} else if (!isSame && loggedInUser == null) {
				mav.addObject("pwMsg", "Passwords do not match");
			} else {
				if (loggedInUser != null && loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
					mav = new ModelAndView("users");
					boolean saveUser = registrationService.saveUser(registrationForm, loggedInUser);
					if (!saveUser) {
						mav = new ModelAndView("newuser");
						mav.addObject("regMsg", "Email has already been taken");
					} else {
						historyService.addActivityHistory(loggedInUser, registrationForm.getEmail(), ADDED_USER);
						mav.setView(new RedirectView("/app/users", true, true, false));
					}
				} else {
					boolean saveUser = false;
					boolean anyRequiredFieldEmpty = registrationService.anyRequiredFieldEmpty(registrationForm);
					if (anyRequiredFieldEmpty) {
						mav = new ModelAndView("register");
						mav.addObject("regMsg", "Required fields are empty.");
					} else {
						saveUser = registrationService.saveUser(registrationForm, loggedInUser);
					}
					if (!saveUser) {
						mav = new ModelAndView("register");
						mav.addObject("regMsg", "Email has already been taken");
					} else {
						mav = new ModelAndView("login");
						mav.addObject("regSuccess", "You have been registered successfully, Please Login to continue.");
						User newRegistrant = userService.findUserByEmail(registrationForm.getEmail());
						historyService.addActivityHistory(newRegistrant, null, REGISTERED);
					}
				}
			}

			return mav;
		}
	}
}
