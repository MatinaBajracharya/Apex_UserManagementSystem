package com.usermgmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.usermgmt.form.RegistrationForm;

@Repository
public class UserDao {

	public final String URL = "jdbc:mysql://localhost:3306/usermanagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public void getAllUsers() {
		try {
			Connection myConn = DriverManager.getConnection(URL, "root", null);
			Statement stmt = myConn.createStatement();

			ResultSet result = stmt.executeQuery("select * from user");
			
			while (result.next()) {
				//result.getString("first_name");
			}

		} catch (Exception e) {
			System.out.println("exception");
		}
	}
	
	
	public void saveUser(RegistrationForm form) {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection(URL, "root", null);
			String query = "insert into user (first_name, last_name, middle_name, email, password, security_ans1, security_ans2) VALUES (?,?,?,?,?,?,?)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, form.getFname());
			stmt.setString(2, form.getLname());
			stmt.setString(3, form.getMname());
			stmt.setString(4, form.getEmail());
			stmt.setString(5, form.getPass1());
			stmt.setString(6, form.getAns1());
			stmt.setString(7, form.getAns2());
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
}
