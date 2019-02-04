package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.DatabaseDAO;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside TransferServlet");
		String left_points = null;
		ArrayList<User> users = null;
		String action = request.getParameter("action");
		User sender =(User) request.getSession().getAttribute("user1");
		String senderEmpId = sender.getEmployeeId();
		System.out.println(action);
		System.out.println(sender.getEmployeeId());
		try{
		 users = DatabaseDAO.getAllUsersDetails();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		for(User user : users){
			System.out.println(user.getEmployeeId() +" " + user.getUserName());
		}
		if("Transfer".equals(action)){
			
			
			RequestDispatcher rd=request.getRequestDispatcher("Transfer.jsp");  
	        request.setAttribute("sender", sender);
	        request.setAttribute("users", users);
	        request.setAttribute("senderName", sender.getUserName());
	        rd.forward(request, response);
		}
		if("Redeem".equals(action)){
			try{
				left_points = DatabaseDAO.getRedeemPoints(senderEmpId);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			RequestDispatcher rd=request.getRequestDispatcher("Redeem.jsp");  
	        request.setAttribute("sender", sender);
	        request.setAttribute("left_points", left_points);
	        rd.forward(request, response);
		}
	}

}
