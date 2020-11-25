package com.leoaslan.model.bo;

import java.sql.SQLException;

import com.leoaslan.conn.Connector;
import com.leoaslan.model.beans.UserAccount;
import com.leoaslan.model.dao.UserAccountDAO;

public class SignUpBO {
	private UserAccountDAO userAccountDAO = new UserAccountDAO();

	public void signup(UserAccount userAccount) throws ClassNotFoundException, SQLException {
		userAccountDAO.createUserAccount(Connector.getMySQLConnection(), userAccount);
	}

}
