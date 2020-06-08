package com.usermgmt.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.usermgmt.form.LoginForm;
import com.usermgmt.model.User;
import com.usermgmt.service.HistoryService;
import com.usermgmt.service.LoginService;

@Controller
@RequestMapping("/app")
public class LoginController {
	
	private final String LOGIN = "LOGIN";

	@Autowired
	LoginService loginService;
	
	@Autowired 
	HistoryService historyService;

	/**
	 * Showing the login page
	 * @return mav
	 */
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	/**
	 * When submit button is pressed, the id of the user is taken to determine the roles of users.
	 * Based on the roles, the users are directed to their respective dashboards. 
	 * The record of logging in is also saved in the history table.
	 * @param loginForm
	 * @param result
	 * @param session
	 * @return mav
	 */
	
	@RequestMapping("/submitLogin")
	public ModelAndView login(@ModelAttribute("loginForm") @Valid LoginForm loginForm, BindingResult result,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors()) {
			return mav;
		} else {
			User user = loginService.findByEmailAndPassword(loginForm);
			if (user == null) {
				mav = new ModelAndView("error");
				return mav;
			}
			if (null != user.getId()) {
				if (null != user.getRole() && user.getRole().equalsIgnoreCase("ADMIN")) {
					mav.setView(new RedirectView("/app/admin/home", true, true, true));
				} else {
					mav.setView(new RedirectView("/app/home", true, true, true));
				}
				session.setAttribute("loggedInUser", user);
				historyService.addActivityHistory(user, null, LOGIN);
			} else {
				mav.addObject("userMsg", "BAD CREDENTIALS");
			}
			return mav;
		}
	}
	
	/*On pressing logout, the session is ended and user is directed to the login page.*/
	
	@RequestMapping("/logout")
	public ModelAndView login(HttpSession session) {
		session.removeAttribute("loggedInUser");
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setView(new RedirectView("/app/login", true, true, true));
		return mav;
	}

}
