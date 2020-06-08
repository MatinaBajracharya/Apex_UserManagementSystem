package com.usermgmt.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.HistoryDao;
import com.usermgmt.dao.UserDao;
import com.usermgmt.serviceImpl.HomeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HomeServiceTest {
	@Mock
	UserDao userDao;
	
	@Mock
	HistoryDao historyDao;
	
	@InjectMocks
	HomeService homeService = new HomeServiceImpl();
	
	@Test
	public void getAdminCountTest() {
		List<Integer> adminIds = new ArrayList<>();
		adminIds.add(1);
		adminIds.add(2);
		adminIds.add(3);
		
		Mockito.when(userDao.getActiveAdmins()).thenReturn(adminIds);
		int adminCount = homeService.getAdminCount();
		assertEquals(adminCount, adminIds.size());
	}
	
	@Test
	public void getActiveUsersCountTest() {
		List<Integer> clientIds = new ArrayList<>();
		clientIds.add(1);
		clientIds.add(2);
		clientIds.add(3);
		
		Mockito.when(userDao.getActiveClients()).thenReturn(clientIds);
		int activeClients = homeService.getActiveUsersCount();
		assertEquals(activeClients, clientIds.size());
	}
	
	@Test
	public void getDeletedUsersCountTest() {
		List<Integer> deletedUsers = new ArrayList<>();
		deletedUsers.add(1);
		deletedUsers.add(2);
		deletedUsers.add(3);
		
		Mockito.when(userDao.getDeletedUsers()).thenReturn(deletedUsers);
		int deletedList = homeService.getDeletedUsersCount();
		assertEquals(deletedList, deletedUsers.size());
	}
	
	@Test
	public void getLoginCountTest() {
		List<Integer> loggedInUser = new ArrayList<>();
		loggedInUser.add(1);
		
		
		Mockito.when(historyDao.getLoggedInNumbers(1)).thenReturn(loggedInUser);
		int loggedIn = homeService.getLoginCount(1);
		assertEquals(loggedIn, loggedInUser.size());
	}

}
