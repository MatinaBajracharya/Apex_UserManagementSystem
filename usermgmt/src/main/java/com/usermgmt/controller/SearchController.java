package com.usermgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.usermgmt.form.SearchForm;
import com.usermgmt.model.User;
import com.usermgmt.service.SearchService;

@Controller
@RequestMapping("/app")
public class SearchController {
	
	@Autowired 
	SearchService searchService;
	
	/**
	 * Searching for users by getting the value from the form.
	 * @param search
	 * @return mav
	 */
	@RequestMapping("/users/search")
	public ModelAndView searchUser(@ModelAttribute("searchString") @Valid SearchForm search) {
		ModelAndView mav = new ModelAndView("users");
		List<User> users = searchService.searchUser(search);
		if(CollectionUtils.isEmpty(users)) {
			mav.addObject("msg", "Users not found.");
			return mav;
		}
		
		mav.addObject("allUsers", users);
		return mav;
		
	}
}
