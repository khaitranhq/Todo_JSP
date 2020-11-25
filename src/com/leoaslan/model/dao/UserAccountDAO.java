package com.leoaslan.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.leoaslan.model.beans.UserAccount;

public class UserAccountDAO {
	public boolean checkExistUser(Connection connection, UserAccount userAccount) throws SQLException {
		String checkExistUserQuery = "select * from UserAccounts where email=? and password=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(checkExistUserQuery);
		preparedStatement.setString(1, userAccount.getEmail());
		preparedStatement.setString(2, userAccount.getPassword());
		ResultSet resultSet = preparedStatement.executeQuery();

		return resultSet.next();
	}
	
	public void createUserAccount(Connection connection, UserAccount userAccount) throws SQLException {
		String createString = "insert into UserAccounts (email, password) values (?, ?);";
		
		PreparedStatement preparedStatement = connection.prepareStatement(createString);
		preparedStatement.setString(1, userAccount.getEmail());
		preparedStatement.setString(2, userAccount.getPassword());
		preparedStatement.executeUpdate();
	}
}
