package com.leoaslan.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "todo_netprog";
		String userName = "root";
		String password = "password";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?allowPublicKeyRetrieval=true&useSSL=false";
		
		Connection connection = DriverManager.getConnection(connectionURL, userName, password);
		
		return connection;
	}
}
