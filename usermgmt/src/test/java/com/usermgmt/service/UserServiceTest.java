package com.usermgmt.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.UserDao;
import com.usermgmt.model.User;
import com.usermgmt.serviceImpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserService userService = new UserServiceImpl();
	
	/**
	 * Preparing mock data instead of calling the actual database then comparing the expected and actual results.
	 */
	
	@Test
	public void getAllUsers() {
		User user = new User();
		user.setId(1);
		user.setEmail("new@user.com");
		
		User user1 = new User();
		user1.setId(2);
		user1.setEmail("another@user.com");
		
		List<User> allUsers = new ArrayList<>();
		allUsers.add(user);
		allUsers.add(user1);
		
		
		Mockito.when(userDao.getAllUsers()).thenReturn(allUsers);
		List<User> mockValues = userService.getAllUsers();
		assertEquals(allUsers.get(0).getId(), mockValues.get(0).getId());
		assertEquals(allUsers.get(0).getEmail(), mockValues.get(0).getEmail());
		assertEquals(allUsers.size(), mockValues.size());
	}
	
}
