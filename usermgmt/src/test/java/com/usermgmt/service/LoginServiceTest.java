package com.usermgmt.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.LoginForm;
import com.usermgmt.model.User;
import com.usermgmt.serviceImpl.LoginServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	LoginService loginService = new LoginServiceImpl();
	
	/**
	 * Preparing mock data instead of calling the actual database.
	 */
	@Test
	public void findByEmailAndPasswordTest() {
		
		LoginForm loginForm = new LoginForm();
		loginForm.setEmail("user@user.com");
		loginForm.setPassword("hello1234");
		
		User user = new User();
		user.setFirstName("Sam");
		user.setEmail(loginForm.getEmail());
		user.setPassword(loginForm.getPassword());
		
		Mockito.when(userDao.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword())).thenReturn(user);
		User mockUserFromDB = loginService.findByEmailAndPassword(loginForm);
		assertEquals(user, mockUserFromDB);
		assertEquals(user.getFirstName(), mockUserFromDB.getFirstName());
		assertEquals(user.getEmail(), mockUserFromDB.getEmail());
		assertEquals(user.getPassword(), mockUserFromDB.getPassword());
	}
	
	@Test
	public void findByEmailAndPasswordTest_EmptyEmailAndPassword() {
		LoginForm loginForm = new LoginForm();
		loginForm.setEmail(null);
		loginForm.setPassword(null);
		
		User mockData = loginService.findByEmailAndPassword(loginForm);
		assertNull(mockData);
	}
		
}

