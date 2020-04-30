package com.usermgmt.service;

import com.usermgmt.form.RegistrationForm;

public interface RegistrationService {
	
	public boolean isPasswordAndConfirmPasswordSame(RegistrationForm registrationForm);

	public void saveUser(RegistrationForm form);
}
