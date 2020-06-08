package com.usermgmt.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.SearchForm;
import com.usermgmt.model.User;
import com.usermgmt.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> searchUser(SearchForm search) {
		List<User> users = userDao.findByName(search.getSearchString());
		users.addAll(userDao.findByLastName(search.getSearchString()));
		return users;
	}

}
