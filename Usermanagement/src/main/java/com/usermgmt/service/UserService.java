package com.usermgmt.service;

import java.util.List;

import com.usermgmt.form.ChangePasswordForm;
import com.usermgmt.form.ForgotPasswordForm;
import com.usermgmt.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	
	boolean isPasswordAndConfirmPasswordSame(String newPassword, String confirmPassword);
	
	boolean updatePassword(String newPassword, String email);
	
	User findUserByEmailAndPassword(ChangePasswordForm changePasswordform);
	
	User findUserByEmail(String email);

	boolean checkAnswers(User existingUser, ForgotPasswordForm forgotPasswordForm);
	
	void deleteUser(Integer deleteUserId);

}

