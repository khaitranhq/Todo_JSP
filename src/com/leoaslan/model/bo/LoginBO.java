package com.leoaslan.model.bo;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

import com.leoaslan.conn.Connector;
import com.leoaslan.model.beans.UserAccount;
import com.leoaslan.model.dao.UserAccountDAO;

public class LoginBO {
	private UserAccountDAO userAccountDAO = new UserAccountDAO();

	public boolean checkLogin(UserAccount userAccount) throws ClassNotFoundException, SQLException {
		return userAccountDAO.checkExistUser(Connector.getMySQLConnection(), userAccount);
	}
	
	public String signToken() throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 5000);
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("sign");
		Scanner scanner = new Scanner(socket.getInputStream());
		String token = scanner.nextLine();
		socket.close();
		scanner.close();
		return token;
	}
	
	public boolean verifyToken(String token) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 5000);
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println("verify");
		printStream.println(token);
		Scanner scanner = new Scanner(socket.getInputStream());
		boolean isAuthenticated = scanner.nextBoolean();
		socket.close();
		scanner.close();
		return isAuthenticated;
	}
}
