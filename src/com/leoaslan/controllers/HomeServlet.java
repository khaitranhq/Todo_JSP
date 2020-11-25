package com.leoaslan.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leoaslan.model.beans.Task;
import com.leoaslan.model.bo.HomeBO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HomeBO homeBO = new HomeBO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void listTodos(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
    	ArrayList<Task> tasks = homeBO.getAllTasks();
    	request.setAttribute("listTasks",tasks);
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/TodoList.jsp");
    	requestDispatcher.forward(request, response);
	}
    
    private void createTodo(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException, ParseException {
    	String taskName = request.getParameter("taskName");
    	String taskDescription = request.getParameter("taskDescription");
    	String targetDate = request.getParameter("targetDate");
    
    	Task task = new Task(taskName, taskDescription, new SimpleDateFormat("yyyy-MM-dd").parse(targetDate));
    	homeBO.insertTask(task);
    	response.sendRedirect("list");
	}
    
    private void showForm(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
    	String taskId = request.getParameter("taskId");
    	
    	if (taskId != null) {
    		Task task = homeBO.getTaskById(Integer.parseInt(taskId));
    		
    		if (task != null) 
    			request.setAttribute("task", task);
    	}
    	
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/CreateTodo.jsp");
    	requestDispatcher.forward(request, response);
	}
    
    private void doneTask(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
    	String taskId = request.getParameter("taskId");
    	System.out.println(taskId);
    	homeBO.changeStatus(Integer.parseInt(taskId), "done");
    	
    	response.sendRedirect("list");
    }
    
    private void editTask(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException, NumberFormatException, ParseException {
    	String taskId = request.getParameter("taskId");
    	String taskName = request.getParameter("taskName");
    	String taskDescription = request.getParameter("taskDescription");
    	String status = request.getParameter("status");
    	String targetDate = request.getParameter("targetDate");
    	
    	Task task = new Task(Integer.parseInt(taskId), taskName, taskDescription, status, new SimpleDateFormat("MM-dd-yyyy").parse(targetDate));
    	
    	homeBO.updateTask(task);
    	
    	response.sendRedirect("list");
    }
    
    private void deleteTask(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ClassNotFoundException, SQLException, IOException {
    	String taskId = request.getParameter("taskId");
    	
    	homeBO.deleteTask(Integer.parseInt(taskId));
    	response.sendRedirect("list");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/list":
				listTodos(request, response); 	
				break;
			case "/form": 
				showForm(request, response);
				break;
			case "/insert":
				createTodo(request, response);
				break;
			case "/done":
				doneTask(request, response);
				break;
			case "/edit":
				editTask(request, response);
				break;
			case "/delete":
				deleteTask(request, response);
				break;
			default:
				break;
			}
//			ArrayList<Task> tasks = new ArrayList<Task>();
//			tasks = homeBO.getAllTasks();
//			
//			System.out.println(tasks.size());
//			
//			request.setAttribute("listTasks", tasks);
//
//			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
//			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
