package com.usermgmt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.usermgmt.model.User;
import com.usermgmt.service.HomeService;


@Controller
@RequestMapping("/app")
public class HomeController {
	
	@Autowired 
	HomeService homeService;
	
	/*After the successful login, client is directed to client's home page.
	 * If an error occurs, error page is displayed.*/
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = null;
		long sessionTime = (System.currentTimeMillis() - session.getCreationTime()) / 60000;
		int loginCount = homeService.getLoginCount(loggedInUser.getId());
		if (loggedInUser != null && loggedInUser.getRole().equalsIgnoreCase("CLIENT")) {
			mav = new ModelAndView("index");
			mav.addObject("sessionTime", sessionTime);
			mav.addObject("loginCount", loginCount);
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}

	/*After the successful login, admin is directed to admin's home page.
	 * If an error occurs, error page is displayed.*/
	
	@RequestMapping("/admin/home")
	public ModelAndView adminHome(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = null;
		if(user != null && user.getRole().equalsIgnoreCase("ADMIN")) {
			mav = new ModelAndView("dashboardAdmin");
			int adminCount = homeService.getAdminCount();
			int activeUsersCount = homeService.getActiveUsersCount();
			int deletedUsersCount = homeService.getDeletedUsersCount();
			mav.addObject("adminCount", adminCount);
			mav.addObject("activeUsersCount", activeUsersCount);
			mav.addObject("deletedUsersCount", deletedUsersCount);
		}else {
			mav = new ModelAndView("error");
		}
		return mav;
	}
}
