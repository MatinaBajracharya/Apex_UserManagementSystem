package com.usermgmt.service;

import java.util.List;

import com.usermgmt.model.History;
import com.usermgmt.model.User;

public interface HistoryService {
	
	/**
	 * adds an entry to the history table along with the type of activity performed.
	 * @param user
	 * @param email
	 * @param activity
	 */
	void addActivityHistory(User user, String email, String activity);
	
	/**
	 * returns everything from the history table in the form of List
	 * @return List<History>
	 */
	List<History> getAllHistory();
	
	/**
	 * returns everything from the history table related to a user.
	 * @param user
	 * @return List<History>
	 */
	List<History> getHistoryByUser(User user);

}
