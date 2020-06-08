package com.usermgmt.service;

import java.util.List;

import com.usermgmt.form.ReportForm;
import com.usermgmt.model.Report;

public interface ReportService {

	/**
	 * Getting data between the date ranges
	 * @param reportForm
	 * @return report
	 */
	List<Report> getDataBetweenDates(ReportForm reportForm);
	

}
