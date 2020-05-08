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
import com.usermgmt.model.User;

@Repository
public class HistoryDao {

	public final String URL = "jdbc:mysql://localhost:3306/usermanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

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
	
	
	public List<History> getHistory() throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<History> historyList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.id, u.first_name, u.last_name, u.email, u.role, h.activity, h.new_user, h.date  FROM user u inner join history h on u.id = h.user_id;";
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
	
	public List<History> getHistoryByUser(User user) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		List<History> historyList = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "SELECT u.id, u.first_name, u.last_name, u.email, u.role, h.activity, h.date  FROM user u inner join history h on u.id = h.user_id where u.id = ?;";
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

}
