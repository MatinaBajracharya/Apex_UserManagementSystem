package com.usermgmt.service;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.usermgmt.dao.HistoryDao;
import com.usermgmt.form.ReportForm;
import com.usermgmt.model.Report;
import com.usermgmt.serviceImpl.ReportServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {
	
	@Mock
	HistoryDao historyDao;
	
	@InjectMocks
	ReportService reportService = new ReportServiceImpl();
	
	/**
	 * Preparing mock data instead of calling the actual database then comparing the expected and actual results.
	 * @throws SQLException
	 */
	
	@Test
	public void getDataBetweenDates() throws SQLException {
		ReportForm reportForm = new ReportForm();
		reportForm.setFrom("2020-01-01");
		reportForm.setTo("2020-01-05");
		
		Report report = new Report();
		report.setEmail("user@user.com");
		report.setActivity("DELETED");
		
		List<Report> listReport = new ArrayList<>();
		listReport.add(report);
		
		
		Mockito.when(historyDao.getReport(reportForm.getFrom(), reportForm.getTo())).thenReturn(listReport);
		List<Report> mockReports = reportService.getDataBetweenDates(reportForm);
		assertEquals(listReport.get(0).getEmail(), mockReports.get(0).getEmail());
		assertEquals(listReport.get(0).getActivity(), mockReports.get(0).getActivity());
	}
}
