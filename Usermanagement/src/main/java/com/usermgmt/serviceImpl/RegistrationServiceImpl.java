package com.usermgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.RegistrationForm;
import com.usermgmt.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	UserDao userDao;

	public boolean isPasswordAndConfirmPasswordSame(RegistrationForm registrationForm) {
		boolean isSame = false;
		if(registrationForm != null) {
			if(registrationForm.getPass1().equalsIgnoreCase(registrationForm.getPass2())) {
				isSame= true;
			}
		}
		return isSame;
	}

	public void saveUser(RegistrationForm form) {
		userDao.saveUser(form);
	}
}
