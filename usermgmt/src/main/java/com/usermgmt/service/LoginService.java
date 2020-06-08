package com.usermgmt.service;

import com.usermgmt.form.LoginForm;
import com.usermgmt.model.User;

public interface LoginService {
	
	/**
	 * searches user to see if user is valid
	 * @param loginForm
	 * @return user
	 */
	User findByEmailAndPassword(LoginForm loginForm);
	
}
