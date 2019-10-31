package edu.ssafy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProxy {
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// 1. Driver 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2 Connection 연결
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "root",
					"root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
