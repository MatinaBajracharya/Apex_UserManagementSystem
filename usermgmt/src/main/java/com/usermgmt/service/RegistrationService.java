package com.usermgmt.service;

import com.usermgmt.form.RegistrationForm;
import com.usermgmt.model.User;

public interface RegistrationService {

	/**
	 * Checking if both passwords are same in registration form
	 * 
	 * @param registrationForm
	 * @return true or false
	 */
	boolean isPasswordAndConfirmPasswordSame(RegistrationForm registrationForm);

	/**
	 * Saving user if email is unique
	 * 
	 * @param form
	 * @param loggedInUser
	 * @return true or false
	 */
	boolean saveUser(RegistrationForm form, User loggedInUser);

	/**
	 * checks if the required fields are empty or not
	 * 
	 * @param updateProfileForm
	 * @return boolean
	 */
	public boolean anyRequiredFieldEmpty(RegistrationForm registrationForm);

}
