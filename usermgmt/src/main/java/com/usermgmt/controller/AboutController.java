package com.usermgmt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class AboutController {
	
	//Calling the about page
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("aboutus");
		return mav;		
	}
	

}
