package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.usermgmt.model.History;
import com.usermgmt.model.Report;
import com.usermgmt.model.User;

@Repository
public class HistoryDao {
	
	/*Connection form database*/
	public final String URL = "jdbc:mysql://localhost:3306/usermanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	
	/**
	 * Saving user id and activity for own profile activities and saving user id, activity and email for the 
	 * activities done by admin to other users.
	 * @param user
	 * @param email
	 * @param activity
	 */
	public void saveActivityHistory(User user, String email, String activity) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query;
			if(email != null) {
				query = "insert into history (user_id, activity, new_user) VALUES (?,?,?)";
			} else {
				query = "insert into history (user_id, activity) VALUES (?,?)";
			}
			
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, user.getId());
			stmt.setString(2, activity);
			if(email != null) {
				stmt.setString(3, email);
			} 
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Getting information of users and activities by joining both the tables
	 * @return historyList
	 * @throws SQLException
	 */
	public List<History> getHistory() throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<History> historyList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.id, u.first_name, u.last_name, u.email,"
					+ " u.role, h.activity, h.new_user, h.date "
					+ " FROM user u inner join history h on u.id = h.user_id "
					+ "where u.status='ACTIVE' order by h.date desc";
			stmt = connection.prepareStatement(query);
			ResultSet result = stmt.executeQuery();
			historyList = new ArrayList<>();
			while (result.next()) {
				History history = new History();
				history.setUserId(result.getInt("id"));
				history.setFirstName(result.getString("first_name"));
				history.setLastName(result.getString("last_name"));
				history.setEmail(result.getString("email"));
				history.setRole(result.getString("role"));
				history.setActivity(result.getString("activity"));
				history.setNewUser(result.getString("new_user"));
				history.setDate(result.getDate("date"));
				historyList.add(history);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				stmt.close();
				connection.close();
		}
		return historyList;
	}
	
	/**
	 * Getting history by logged in user
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public List<History> getHistoryByUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<History> historyList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.id, u.first_name, u.last_name, u.email, u.role, h.activity, h.date  FROM user u inner join history h on u.id = h.user_id where u.id = ? order by h.date desc";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, user.getId());
			ResultSet result = stmt.executeQuery();
			historyList = new ArrayList<>();
			while (result.next()) {
				History history = new History();
				history.setUserId(result.getInt("id"));
				history.setFirstName(result.getString("first_name"));
				history.setLastName(result.getString("last_name"));
				history.setEmail(result.getString("email"));
				history.setRole(result.getString("role"));
				history.setActivity(result.getString("activity"));
				history.setDate(result.getDate("date"));
				historyList.add(history);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				stmt.close();
				connection.close();
		}
		return historyList;
	}
	
	/**
	 * Getting history of deleted or registered users by selecting a date range
	 * @param from
	 * @param to
	 * @return reportList
	 * @throws SQLException
	 */
	public List<Report> getReport(String from, String to) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Report> reportList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.first_name, u.last_name, u.email, h.activity, h.date "
					+ "FROM user u inner join history h on u.email = h.new_user " + 
					"			where (h.activity = 'DELETED_USER'" + 
					"			or h.activity = 'ADDED_USER'" + 
					"			or h.activity = 'REGISTERED')" + 
					"			and h.date >= ?" + 
					"			and h.date <= ? order by h.date desc";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, from);
			stmt.setString(2, to);
			ResultSet result = stmt.executeQuery();
			reportList = new ArrayList<>();
			while (result.next()) {
				Report report = new Report();
				report.setFirstName(result.getString("first_name"));
				report.setLastName(result.getString("last_name"));
				report.setEmail(result.getString("email"));
				report.setActivity(result.getString("activity"));
				report.setDate(result.getDate("date"));
				reportList.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				stmt.close();
				connection.close();
		}
		return reportList;
	}
	
	public List<Report> getSelfRegisteredClientsReport(String from, String to) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<Report> reportList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.first_name, u.last_name, u.email, h.activity, h.date "
					+ "FROM user u inner join history h on u.id = h.user_id " + 
					"			where h.activity = 'REGISTERED'" + 
					"			and h.date >= ?" + 
					"			and h.date <= ? order by h.date desc";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, from);
			stmt.setString(2, to);
			ResultSet result = stmt.executeQuery();
			reportList = new ArrayList<>();
			while (result.next()) {
				Report report = new Report();
				report.setFirstName(result.getString("first_name"));
				report.setLastName(result.getString("last_name"));
				report.setEmail(result.getString("email"));
				report.setActivity(result.getString("activity"));
				report.setDate(result.getDate("date"));
				reportList.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				stmt.close();
				connection.close();
		}
		return reportList;
	}
	
	/**
	 * Getting the logged in user's login activity to generate count
	 * @param id
	 * @return
	 */
	public List<Integer> getLoggedInNumbers(int id) {
		PreparedStatement stmt = null;
		Connection connection = null;
		List<Integer> ids = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String query = "select id from history where ACTIVITY = 'LOGIN' "
					+ "and USER_ID = ?";
			connection = DriverManager.getConnection(URL, "root", null);
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			ids = new ArrayList<>();
			while (result.next()) {
				ids.add(result.getInt("id"));
			}
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			try {
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return ids;
	}
	
}
