package com.usermgmt.service;

import java.util.List;

import com.usermgmt.form.ChangePasswordForm;
import com.usermgmt.form.ForgotPasswordForm;
import com.usermgmt.form.UpdateProfileForm;
import com.usermgmt.model.User;

public interface UserService {
	
	/**
	 * Getting data of all users
	 * @return user list
	 */
	List<User> getAllUsers();
	
	/**
	 * Checking if two passwords match
	 * @param newPassword
	 * @param confirmPassword
	 * @return true or false
	 */
	boolean isPasswordAndConfirmPasswordSame(String newPassword, String confirmPassword);
	
	
	/**
	 * passing new password and email to save into database
	 * @param newPassword
	 * @param email
	 * @return true or false
	 */
	boolean updatePassword(String newPassword, String email);
	
	/**
	 * Finding user by email and password to change password
	 * @param changePasswordform
	 * @return user
	 */
	User findUserByEmailAndPassword(ChangePasswordForm changePasswordform);
	
	/**
	 * Checking to see if user with same email exists
	 * @param email
	 * @return user
	 */
	User findUserByEmail(String email);
	
	/**
	 * Finding user by id to update information
	 * @param id
	 * @return user
	 */
	User findUserById(Integer id);

	/**
	 * Checking if answer match
	 * @param existingUser
	 * @param forgotPasswordForm
	 * @return checkAnswer
	 */
	boolean checkAnswers(User existingUser, ForgotPasswordForm forgotPasswordForm);
	
	/**
	 * Deleting user with the passed id
	 * @param deleteUserId
	 */
	void deleteUser(Integer deleteUserId);

	/**
	 * Getting value in the update profile form
	 * @param updateProfileForm
	 * @param id
	 * @return updated
	 */
	boolean updateUserDetails(UpdateProfileForm updateProfileForm, Integer id);
	
	/**
	 * Checking if any field is empty
	 * @param updateProfileForm
	 * @return true or false
	 */
	boolean checkRequiredFields(UpdateProfileForm updateProfileForm);

}

