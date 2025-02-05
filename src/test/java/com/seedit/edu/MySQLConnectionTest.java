package com.seedit.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MySQLConnectionTest {

	static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String URL = "jdbc:mysql://192.168.0.3:3306/board?useSSL=false";
	static final String USERNAME = "education";
	static final String PASSWORD = "education";
	
	@Test
	public void getMySQLConnectionTest() {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			System.out.println("==================== MySQL Connection START ===================");
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			stmt = conn.createStatement();
			
			String sql = "SELECT BOARD_SUBJECT, BOARD_CONTENT, BOARD_WRITER FROM TB_BOARD";
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				String boardSubject = rs.getString("BOARD_SUBJECT");
				String boardContent = rs.getString("BOARD_CONTENT");
				String boardWriter = rs.getString("BOARD_WRITER");
				
				System.out.print("boardSubject : " + boardSubject + ", ");
				System.out.print("boardContent: " + boardContent + ", ");
				System.out.println("boardWriter: " + boardWriter);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se1) {
			se1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		System.out.println("==================== MySQL Connection END ===================");
	}
}
