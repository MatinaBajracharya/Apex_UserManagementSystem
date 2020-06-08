package com.usermgmt.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.HistoryDao;
import com.usermgmt.model.History;
import com.usermgmt.model.User;
import com.usermgmt.serviceImpl.HistoryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class HistroyServiceTest {
	
	@Mock
	HistoryDao historyDao;
	
	@InjectMocks
	HistoryService historyService = new HistoryServiceImpl();
	
	/**
	 * Preparing mock data instead of calling the actual database then comparing the expected and actual results.
	 * @throws SQLException
	 */
	
	@Test
	public void getAllHistoryTest() throws SQLException {
		List<History> historyList = new ArrayList<>();
		History history1 = new History();
		history1.setUserId(123);
		history1.setEmail("test@test.com");
		historyList.add(history1);
		
		History history2 = new History();
		history2.setUserId(456);
		history2.setEmail("second@test.com");
		historyList.add(history2);
		
		Mockito.when(historyDao.getHistory()).thenReturn(historyList);
		List<History> allHistory = historyService.getAllHistory();
		assertFalse(allHistory.isEmpty());
		assertEquals(historyList.size(), allHistory.size());
		assertEquals(historyList.get(0).getEmail(), allHistory.get(0).getEmail());
		assertEquals(historyList.get(1).getUserId(), allHistory.get(1).getUserId());
	}
	
	@Test
	public void getHistoryByUserTest() throws SQLException {
		List<History> historyList = new ArrayList<>();
		History history1 = new History();
		history1.setUserId(1);
		historyList.add(history1);
		
		User user = new User();
		user.setId(1);
		Mockito.when(historyDao.getHistoryByUser(user)).thenReturn(historyList);
		List<History> historyByUser = historyService.getHistoryByUser(user);
		assertEquals(historyList.get(0).getUserId(), historyByUser.get(0).getUserId());
		assertEquals(historyList.size(), historyByUser.size());
	}
}
