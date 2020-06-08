package com.usermgmt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.usermgmt.form.UpdateProfileForm;
import com.usermgmt.model.User;
import com.usermgmt.service.HistoryService;
import com.usermgmt.service.ProfileService;

@Controller
@RequestMapping("/app")
public class ProfileController {
	
	private static final String PROFILE_UPDATE = "UPDATED_PROFILE";
	
	@Autowired 
	ProfileService profileService;
	
	@Autowired
	HistoryService historyService;

	/**
	 * Based on the role of the logged in user, they are directed to their respective profile pages.
	 * If any error occurs, error  page is shown.
	 * @param session
	 * @return
	 */
	
	@RequestMapping("/profile")
	public ModelAndView profile(HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = null;
		if (user != null && user.getRole().equalsIgnoreCase("CLIENT")) {
			mav = new ModelAndView("profileClient");
			mav.addObject("user", user);
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
			mav.addObject("user", user);
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}
	
	/*If the update form has no errors then the profile of the user is updated and is redirected to the profile page.
	 * The history table is also updated.
	 * Else, an error is thrown. */
	
	@RequestMapping("/profile/update")
	public ModelAndView updateUser(@ModelAttribute("updateProfile") UpdateProfileForm updateProfileForm,
			HttpSession session) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		ModelAndView mav = new ModelAndView();
		if (loggedInUser == null) {
			mav = new ModelAndView("error");
			return mav;
		}
		boolean anyRequiredFieldEmpty = profileService.anyRequiredFieldEmpty(updateProfileForm);
		if(!anyRequiredFieldEmpty) {
			boolean updated = profileService.updateProfile(updateProfileForm, loggedInUser.getId());
			if (updated) {
				historyService.addActivityHistory(loggedInUser, null, PROFILE_UPDATE);
				updateUserInSession(session, updateProfileForm);   //calling private method
			}
			if (loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
				mav.setView(new RedirectView("/app/admin/profile", true, true, false));
			} else {
				mav.setView(new RedirectView("/app/profile", true, true, false));
			}
		} else {
			if(loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
				mav.setView(new RedirectView("/app/admin/profile", true, true, false));
			} else {
				mav.setView(new RedirectView("/app/profile", true, true, false));
			}
		}
		return mav;
	}
	
	/*Getting logged in user's information and setting it in the 'update profile' form.*/
	private void updateUserInSession(HttpSession session, UpdateProfileForm updateProfileForm) {
		User user = (User) session.getAttribute("loggedInUser");
		user.setFirstName(updateProfileForm.getFirstName());
		user.setLastName(updateProfileForm.getLastName());
		user.setMiddleName(updateProfileForm.getMiddleName());
		user.setEmail(updateProfileForm.getEmail());
		session.setAttribute("loggedInUser", user);
	}

}
