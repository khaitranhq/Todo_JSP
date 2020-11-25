package com.leoaslan.model.bo;

import java.sql.SQLException;

import com.leoaslan.conn.Connector;
import com.leoaslan.model.beans.UserAccount;
import com.leoaslan.model.dao.UserAccountDAO;

public class LoginBO {
	private UserAccountDAO userAccountDAO = new UserAccountDAO();

	public boolean checkLogin(UserAccount userAccount) throws ClassNotFoundException, SQLException {
		return userAccountDAO.checkExistUser(Connector.getMySQLConnection(), userAccount);
	}
}
