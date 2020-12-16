package com.leoaslan.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leoaslan.model.beans.UserAccount;
import com.leoaslan.model.bo.LoginBO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginBO loginBO = new LoginBO();

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Login.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserAccount userAccount = new UserAccount(email, password);
		try {
			if (loginBO.checkLogin(userAccount)) {
				String token = loginBO.signToken();
				
				Cookie cookie = new Cookie("auth", token);
				cookie.setMaxAge(60*60*24);
				
				response.addCookie(cookie);
				response.sendRedirect(request.getContextPath() + "/list");
			}
			else {
				request.setAttribute("incorrect", true);
				doGet(request, response);
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-genserated catch block
			e.printStackTrace();
		}
	}

}
