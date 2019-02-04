package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.DatabaseDAO;

/**
 * Servlet implementation class TransferFinal
 */
@WebServlet("/TransferFinal")
public class TransferFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User sender =(User) request.getSession().getAttribute("sender");
			String from = sender.getEmployeeId();
			String to = request.getParameter("to_user");
			int to_sample = Integer.parseInt(to.trim());
			String amount =  request.getParameter("amount");
			String message = request.getParameter("message");
			System.out.println("From : " +from+" \n"+ "name :"+ sender.getUserName() +"\n To :"+ to_sample + "\n Amount : " + amount+" \n message :" + message);
			try{
				DatabaseDAO.insertTxnDetails(from,to_sample, amount, message);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}

}
