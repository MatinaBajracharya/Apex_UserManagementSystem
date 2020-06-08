package com.usermgmt.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.RegistrationForm;
import com.usermgmt.model.User;
import com.usermgmt.serviceImpl.RegistrationServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	RegistrationService registrationService = new RegistrationServiceImpl();	
	
	@Test
	public void isPasswordAndConfirmPasswordSameTest_WithDifferentPasswords() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPass1("test1");
		registrationForm.setPass2("test2");
		boolean passwordMatch = registrationService.isPasswordAndConfirmPasswordSame(registrationForm);
		assertFalse(passwordMatch);
	}
	
	@Test
	public void isPasswordAndConfirmPasswordSameTest_WithSamePasswords() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPass1("same");
		registrationForm.setPass2("same");
		boolean passwordMatch = registrationService.isPasswordAndConfirmPasswordSame(registrationForm);
		assertTrue(passwordMatch);
	}
	
	@Test
	public void anyRequiredFieldEmptyTest_WithEmptyFields() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPass1("test");
		registrationForm.setPass2("test");
		registrationForm.setFname("James");
		registrationForm.setLname("Smith");
		
		boolean anyRequiredFieldEmpty = registrationService.anyRequiredFieldEmpty(registrationForm);
		assertTrue(anyRequiredFieldEmpty);
	}
	
	@Test
	public void anyRequiredFieldEmptyTest_WithAllFields() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setPass1("test");
		registrationForm.setPass2("test");
		registrationForm.setFname("James");
		registrationForm.setLname("Smith");
		registrationForm.setEmail("test@test.com");
		registrationForm.setRole("ADMIN");
		registrationForm.setAns1("answer1");
		registrationForm.setAns2("answer2");
		
		boolean anyRequiredFieldEmpty = registrationService.anyRequiredFieldEmpty(registrationForm);
		assertFalse(anyRequiredFieldEmpty);
	}
	
	@Test
	public void saveUserTest_SaveSuccess() {
		RegistrationForm form = new RegistrationForm();
		form.setEmail("test@test.com");
		
		User user = new User();
		user.setId(1);
		
		Mockito.when(userDao.findByEmail(form.getEmail())).thenReturn(user);
		boolean saveUser = registrationService.saveUser(form, user);
		assertTrue(saveUser);
	}
	
	@Test
	public void saveUserTest_SaveFail() {
		RegistrationForm form = new RegistrationForm();
		form.setEmail("test@test.com");
		
		User user = new User();
		user.setId(1);
		user.setFirstName("test");
		
		Mockito.when(userDao.findByEmail(form.getEmail())).thenReturn(user);
		boolean saveUser = registrationService.saveUser(form, user);
		assertFalse(saveUser);
	}
}
