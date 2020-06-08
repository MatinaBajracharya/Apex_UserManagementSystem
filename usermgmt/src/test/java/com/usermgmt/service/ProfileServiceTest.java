package com.usermgmt.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.UserDao;
import com.usermgmt.form.UpdateProfileForm;
import com.usermgmt.serviceImpl.ProfileServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {

	@Mock
	UserDao userDao;

	@InjectMocks
	ProfileService profileService = new ProfileServiceImpl();

	/**
	 * Preparing mock data instead of calling the actual database.
	 */
	@Test
	public void updateProfileTest() throws SQLException {

		UpdateProfileForm updateProfileForm = new UpdateProfileForm();

		Mockito.doNothing().when(userDao).updateUser(updateProfileForm.getFirstName(), updateProfileForm.getLastName(),
				updateProfileForm.getMiddleName(), updateProfileForm.getEmail(), updateProfileForm.getAns1(),
				updateProfileForm.getAns2(), 1);
		boolean mockUpdated = profileService.updateProfile(updateProfileForm, 1);
		assertTrue(mockUpdated);

	}
	
	@Test
	public void anyRequiredFieldEmptyTest() {
		UpdateProfileForm updateProfileForm = new UpdateProfileForm();
		
		boolean result = profileService.anyRequiredFieldEmpty(updateProfileForm);
		assertTrue(result);
	}
	
	@Test
	public void anyRequiredFieldEmptyTest_WithEmptyData() {
		UpdateProfileForm updateProfileForm = new UpdateProfileForm();
		updateProfileForm.setFirstName("Ram");
		updateProfileForm.setLastName("Shrestha");
		updateProfileForm.setEmail("ram@gmail.com");
		updateProfileForm.setAns1("ktm");
		updateProfileForm.setAns2("bruno");		
		
		boolean result = profileService.anyRequiredFieldEmpty(updateProfileForm);
		assertFalse(result);
	}

}
