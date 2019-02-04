package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.DatabaseDAO;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Main controller");
		User user = null;
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println("userName entered : " + uname + "\n" + "Password : ******" );
		try {
			System.out.println(" Validating User");
			user = DatabaseDAO.validateAdmin(uname, pwd);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	//	String username = user.getUserName();
	//	String empName = user.getUserName();
		System.out.println(user.getUserName());
		System.out.println(user);
		System.out.println(user.getUserPwd());
		System.out.println(user.getAdmin());

		if (uname.equals(user.getUserName()) && pwd.equals(user.getUserPwd()) && "Y".equals(user.getAdmin())
				&& user != null) {
			System.out.println("User ia an Admin");
	        RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp"); 
	      //  request.setAttribute("user", empName);
	        request.setAttribute("user", user);
	        rd.forward(request, response);
			//response.sendRedirect("Admin.jsp");
			
		} else if (uname.equals(user.getUserName()) && pwd.equals(user.getUserPwd()) && "N".equals(user.getAdmin())
				&& user != null) {
			System.out.println("User ia an not admin");

			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");  
			request.setAttribute("user", user);  
	        rd.forward(request, response);
		//	response.sendRedirect("success.jsp");
			
		} else {
			response.sendRedirect("failure.jsp");
			
		}

		
		
	
	}
}
