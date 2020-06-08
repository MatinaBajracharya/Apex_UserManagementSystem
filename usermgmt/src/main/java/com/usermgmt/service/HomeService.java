package com.usermgmt.service;

public interface HomeService {
	/**
	 * Getting list of Admin to get the count
	 * @return count
	 */
	int getAdminCount();
	
	/**
	 * Getting users with the role 'Active' to get count
	 * @return
	 */
	int getActiveUsersCount();
	
	/**
	 * Getting users with role 'Deleted' to get count
	 * @return
	 */
	int getDeletedUsersCount();

	/**
	 * Getting the login count of logged in user by passing id
	 * @param id
	 * @return
	 */
	int getLoginCount(Integer id);

}
