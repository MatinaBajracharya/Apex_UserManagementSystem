package com.usermgmt.service;

import java.util.List;

import com.usermgmt.form.SearchForm;
import com.usermgmt.model.User;

public interface SearchService {
	
	/**
	 * Searching user by passing value obtained from search form
	 * @param search
	 * @return users
	 */
	List<User> searchUser(SearchForm search);
}
