package com.usermgmt.service;

import com.usermgmt.form.UpdateProfileForm;

public interface ProfileService {
	
	/**
	 * With the help of user id, user's information is accessed
	 * @param updateProfileForm
	 * @param id
	 * @return true or false
	 */
	boolean updateProfile(UpdateProfileForm updateProfileForm, Integer id);
	
	/**
	 * To see if any field is empty
	 * @param updateProfileForm
	 * @return true or false
	 */
	boolean anyRequiredFieldEmpty(UpdateProfileForm updateProfileForm);

}
