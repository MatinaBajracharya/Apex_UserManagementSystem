package com.usermgmt.form;

import javax.validation.constraints.NotEmpty;

public class SearchForm {
	
	@NotEmpty
	private String searchString;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	

}
