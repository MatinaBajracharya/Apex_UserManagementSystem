package com.usermgmt.serviceImpl;

import org.springframework.stereotype.Service;

import com.usermgmt.form.RegistrationForm;
import com.usermgmt.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{

	public boolean isPasswordAndConfirmPasswordSame(RegistrationForm registrationForm) {
		boolean isSame = false;
		if(registrationForm != null) {
			if(registrationForm.getPass1().equalsIgnoreCase(registrationForm.getPass2())) {
				isSame= true;
			}
		}
		return isSame;
	}
	

}
