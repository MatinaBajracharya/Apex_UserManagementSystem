package com.usermgmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.usermgmt.dao.HistoryDao;
import com.usermgmt.dao.UserDao;
import com.usermgmt.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService	{
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	HistoryDao historyDao;

	@Override
	public int getAdminCount() {
		int size = 0;
		List<Integer> activeAdmins = userDao.getActiveAdmins();
		if(!CollectionUtils.isEmpty(activeAdmins)) {
			size = activeAdmins.size();
		}
		return size;
	}

	@Override
	public int getActiveUsersCount() {
		int size = 0;
		List<Integer> clients = userDao.getActiveClients();
		if(!CollectionUtils.isEmpty(clients)) {
			size = clients.size();
		}
		return size;
	}

	@Override
	public int getDeletedUsersCount() {
		int size = 0;
		List<Integer> deletedUsersIds = userDao.getDeletedUsers();
		if(!CollectionUtils.isEmpty(deletedUsersIds)) {
			size = deletedUsersIds.size();
		}
		return size;
	}

	@Override
	public int getLoginCount(Integer id) {
		int size = 0;
		List<Integer> ids = historyDao.getLoggedInNumbers(id);
		if(!CollectionUtils.isEmpty(ids)) {
			size = ids.size();
		}
		return size;
	}
}
