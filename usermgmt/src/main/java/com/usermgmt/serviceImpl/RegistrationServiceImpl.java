package com.usermgmt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.RegistrationForm;
import com.usermgmt.model.User;
import com.usermgmt.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	UserDao userDao;

	@Override
	public boolean isPasswordAndConfirmPasswordSame(RegistrationForm registrationForm) {
		boolean isSame = false;
		if (registrationForm != null && null != registrationForm.getPass1() && null != registrationForm.getPass2()) {
			if (registrationForm.getPass1().equalsIgnoreCase(registrationForm.getPass2())) {
				isSame = true;
			}
		}
		return isSame;
	}

	@Override
	public boolean saveUser(RegistrationForm form, User loggedInUser) {
		boolean userSaved = false;
		User existingUser = userDao.findByEmail(form.getEmail());
		if (existingUser.getFirstName() == null) {
			userDao.saveUser(form, loggedInUser);
			userSaved = true;
		}
		return userSaved;
	}
	
	@Override
	public boolean anyRequiredFieldEmpty(RegistrationForm registrationForm) {
		if (StringUtils.isEmpty(registrationForm.getFname())
				|| StringUtils.isEmpty(registrationForm.getLname())
				|| StringUtils.isEmpty(registrationForm.getEmail()) 
				|| StringUtils.isEmpty(registrationForm.getAns1())
				|| StringUtils.isEmpty(registrationForm.getAns2()) 
				|| StringUtils.isEmpty(registrationForm.getPass1())
				|| StringUtils.isEmpty(registrationForm.getPass2())) {
			return true;
		}
		return false;
	}

}
